package cn.ganjiacheng.spark;

import cn.ganjiacheng.antlr.SparkSqlBaseVisitor;
import cn.ganjiacheng.antlr.SparkSqlParser;
import cn.ganjiacheng.enums.SqlTypeEnum;

/**
 * @ClassName SparkSqlTypeParser
 * @description:
 * @author: again
 * @Date: 2021/3/11 8:08 下午
 */
public class SparkSqlTypeParser extends SparkSqlBaseVisitor {

    private SqlTypeEnum sqlType = null;

    private void initSqlTypeEnum(SqlTypeEnum type) {
        if(sqlType == null) {
            sqlType = type;
        }
    }

    public SqlTypeEnum getSqlType() {
        return sqlType;
    }

    @Override
    public Object visitSingleInsertQuery(SparkSqlParser.SingleInsertQueryContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.INSERT);
        return super.visitSingleInsertQuery(ctx);
    }

    @Override
    public Object visitSelectClause(SparkSqlParser.SelectClauseContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.SELECT);
        return super.visitSelectClause(ctx);
    }

    @Override
    public Object visitDeleteFromTable(SparkSqlParser.DeleteFromTableContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.DELETE);
        return super.visitDeleteFromTable(ctx);
    }

    @Override
    public Object visitUpdateTable(SparkSqlParser.UpdateTableContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.UPDATE);
        return super.visitUpdateTable(ctx);
    }

    @Override
    public Object visitCreateTable(SparkSqlParser.CreateTableContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.CREATE);
        return super.visitCreateTable(ctx);
    }
}
