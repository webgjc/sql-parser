package cn.ganjiacheng.mysql;

import cn.ganjiacheng.antlr.MySqlParserBaseVisitor;
import cn.ganjiacheng.antlr.MySqlParser;
import cn.ganjiacheng.enums.SqlTypeEnum;

/**
 * @ClassName MysqlSqlTypeParser
 * @description:
 * @author: again
 * @Date: 2021/3/10 5:09 下午
 */
public class MysqlSqlTypeParser extends MySqlParserBaseVisitor {

    private SqlTypeEnum sqlType = null;

    private void initSqlTypeEnum(SqlTypeEnum type) {
        if(sqlType == null) {
            sqlType = type;
        }
    }

    @Override
    public Object visitSimpleSelect(MySqlParser.SimpleSelectContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.SELECT);
        return super.visitSimpleSelect(ctx);
    }

    @Override
    public Object visitUpdateStatement(MySqlParser.UpdateStatementContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.UPDATE);
        return super.visitUpdateStatement(ctx);
    }

    @Override
    public Object visitInsertStatement(MySqlParser.InsertStatementContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.INSERT);
        return super.visitInsertStatement(ctx);
    }

    @Override
    public Object visitColumnCreateTable(MySqlParser.ColumnCreateTableContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.CREATE);
        return super.visitColumnCreateTable(ctx);
    }

    @Override
    public Object visitSingleDeleteStatement(MySqlParser.SingleDeleteStatementContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.DELETE);
        return super.visitSingleDeleteStatement(ctx);
    }

    public SqlTypeEnum getSqlType() {
        return sqlType;
    }

}
