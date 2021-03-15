package cn.ganjiacheng.hive;

import cn.ganjiacheng.antlr.HiveSqlBaseVisitor;
import cn.ganjiacheng.antlr.HiveSqlParser;
import cn.ganjiacheng.model.metadata.FieldMetadataModel;
import cn.ganjiacheng.model.metadata.TableMetadataModel;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName HiveSqlMetadataParser
 * @description:
 * @author: again
 * @Date: 2021/3/10 7:41 下午
 */
public class HiveSqlMetadataParser extends HiveSqlBaseVisitor {

    private final TableMetadataModel tableMetadata = new TableMetadataModel();

    private final String sourceSQL;

    /**
     * 保存原始sql
     */
    public HiveSqlMetadataParser(String sql) {
        this.sourceSQL = sql;
    }

    /**
     * 截取原始sql
     * @param parserRuleContext
     * @return
     */
    private String subSourceSql(ParserRuleContext parserRuleContext) {
        return sourceSQL.substring(
                parserRuleContext.getStart().getStartIndex(),
                parserRuleContext.getStop().getStopIndex() + 1);
    }

    /**
     * 处理备注中的引号
     */
    private String dealComment(String comment) {
        if(comment != null && comment.length() >= 2
                && comment.startsWith("'") && comment.endsWith("'")){
            comment = comment.substring(1, comment.length()-1);
        }
        return comment;
    }

    /**
     * 处理表名字段名中的``
     * @param name
     * @return
     */
    private String dealNameMark(String name) {
        if(name.startsWith("`") && name.endsWith("`")) {
            return name.substring(1, name.length()-1);
        }else {
            return name;
        }
    }

    /**
     * 获取到字段信息
     * @param ctx
     */
    private void setTableField(HiveSqlParser.Create_table_stmtContext ctx) {
        List<HiveSqlParser.Create_table_columns_itemContext> itemContexts =
                ctx.create_table_definition().create_table_columns().create_table_columns_item();
        List<FieldMetadataModel> fields = new ArrayList<>();
        itemContexts.forEach(item -> {
            FieldMetadataModel field = new FieldMetadataModel();
            field.setFieldName(Optional.of(item)
                    .map(HiveSqlParser.Create_table_columns_itemContext::column_name)
                    .map(RuleContext::getText)
                    .map(this::dealNameMark)
                    .orElse(null));
            String type = Optional.of(item)
                    .map(HiveSqlParser.Create_table_columns_itemContext::dtype)
                    .map(RuleContext::getText)
                    .orElse(null);
            String typeLen = Optional.of(item)
                    .map(HiveSqlParser.Create_table_columns_itemContext::dtype_len)
                    .map(RuleContext::getText)
                    .orElse("");
            field.setDataType(type != null ? type + typeLen : null);
            field.setFieldComment(Optional.of(item)
                    .map(HiveSqlParser.Create_table_columns_itemContext::column_comment)
                    .map(RuleContext::getText)
                    .map(this::dealComment)
                    .orElse(null));
            fields.add(field);
        });
        tableMetadata.setFields(fields);
    }

    /**
     * 获取表其他属性信息
     * @param ctx
     */
    private void setTableOption(HiveSqlParser.Create_table_stmtContext ctx) {
//        HiveSqlParser.Create_table_options_hive_itemContext tableOption =
//                ctx.create_table_definition().create_table_options().create_table_options_hive_item();
//        tableMetadata.setTableComment(Optional.ofNullable(tableOption)
//                .map(HiveSqlParser.Create_table_options_hive_itemContext::string)
//                .map(RuleContext::getText)
//                .map(this::dealComment)
//                .orElse(null));
//        tableMetadata.setPartition(Optional.ofNullable(tableOption)
//                .map(HiveSqlParser.Create_table_options_hive_itemContext::create_table_hive_partitioned_by_clause)
//                .map(this::subSourceSql)
//                .orElse(null));
//        tableMetadata.setRowFormat(Optional.ofNullable(tableOption)
//                .map(HiveSqlParser.Create_table_options_hive_itemContext::create_table_hive_row_format)
//                .map(this::subSourceSql)
//                .orElse(null));
//        tableMetadata.setStore(Optional.ofNullable(tableOption)
//                .map(HiveSqlParser.Create_table_options_hive_itemContext::create_table_hive_stored)
//                .map(this::subSourceSql)
//                .orElse(null));
//        tableMetadata.setLocation(Optional.ofNullable(tableOption)
//                .map(HiveSqlParser.Create_table_options_hive_itemContext::create_table_hive_location)
//                .map(this::subSourceSql)
//                .orElse(null));
//        tableMetadata.setProperties(Optional.ofNullable(tableOption)
//                .map(HiveSqlParser.Create_table_options_hive_itemContext::create_table_hive_tblproperties)
//                .map(this::subSourceSql)
//                .orElse(null));
    }

    /**
     * 获取到表相关信息
     * @param ctx
     * @return
     */
    @Override
    public Object visitCreate_table_stmt(HiveSqlParser.Create_table_stmtContext ctx) {
        List<ParseTree> tbNameTree = ctx.table_name().ident().children;
        if(tbNameTree.size() == 3 && tbNameTree.get(1).getText().equals(".")) {
            tableMetadata.setDbName(tbNameTree.get(0).getText());
            tableMetadata.setTableName(dealNameMark(tbNameTree.get(2).getText()));
        }else{
            tableMetadata.setTableName(dealNameMark(tbNameTree.get(0).getText()));
        }
//        tableMetadata.setTableType(Optional.of(ctx)
//                .map(HiveSqlParser.Create_table_stmtContext::T_EXTERNAl)
//                .map(ParseTree::getText)
//                .orElse(null));
        setTableField(ctx);
        setTableOption(ctx);
        return super.visitCreate_table_stmt(ctx);
    }

    /**
     * 获取全部创表信息
     */
    public TableMetadataModel getTableMetadata() {
        return this.tableMetadata;
    }
}
