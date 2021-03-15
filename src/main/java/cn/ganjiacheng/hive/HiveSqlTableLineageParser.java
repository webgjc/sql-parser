package cn.ganjiacheng.hive;

import cn.ganjiacheng.antlr.HiveSqlBaseVisitor;
import cn.ganjiacheng.antlr.HiveSqlParser;
import cn.ganjiacheng.model.lineage.TableLineageModel;
import cn.ganjiacheng.model.lineage.TableNameModel;
import org.antlr.v4.runtime.RuleContext;

import java.util.HashSet;
import java.util.Optional;

/**
 * @ClassName HiveTableLineage
 * @description:
 * @author: again
 * @Date: 2021/3/10 8:47 下午
 */
public class HiveSqlTableLineageParser extends HiveSqlBaseVisitor {

    private TableNameModel outputTable;
    private final HashSet<TableNameModel> inputTables = new HashSet<>();

    /**
     * visitInsert获取insert的table_name节点，作为目标输出表
     * @param ctx
     * @return
     */
    @Override
    public Object visitInsert_stmt(HiveSqlParser.Insert_stmtContext ctx) {
        outputTable = Optional.ofNullable(ctx)
                .map(HiveSqlParser.Insert_stmtContext::table_name)
                .map(RuleContext::getText)
                .map(TableNameModel::parseTableName)
                .orElse(null);
        return super.visitInsert_stmt(ctx);
    }

    /**
     * 获取from真实表，加到来源表的Set里
     * @param ctx
     * @return
     */
    @Override
    public Object visitFrom_table_clause(HiveSqlParser.From_table_clauseContext ctx) {
        Optional.ofNullable(ctx)
                .map(HiveSqlParser.From_table_clauseContext::from_table_name_clause)
                .map(RuleContext::getText)
                .map(TableNameModel::parseTableName)
                .map(inputTables::add);
        return super.visitFrom_table_clause(ctx);
    }

    public TableLineageModel getTableLineage() {
        TableLineageModel tableLineageModel = new TableLineageModel();
        tableLineageModel.setOutputTable(outputTable);
        tableLineageModel.setInputTables(inputTables);
        return tableLineageModel;
    }
}
