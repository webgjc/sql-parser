package cn.ganjiacheng.presto;

import cn.ganjiacheng.antlr.PrestoSqlBaseVisitor;
import cn.ganjiacheng.antlr.PrestoSqlParser;
import cn.ganjiacheng.enums.SqlTypeEnum;

/**
 * @ClassName PrestoSqlTypeParser
 * @description:
 * @author: again
 * @Date: 2021/3/11 7:59 下午
 */
public class PrestoSqlTypeParser extends PrestoSqlBaseVisitor {

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
    public Object visitCreateTable(PrestoSqlParser.CreateTableContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.CREATE);
        return super.visitCreateTable(ctx);
    }

    @Override
    public Object visitInsertInto(PrestoSqlParser.InsertIntoContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.INSERT);
        return super.visitInsertInto(ctx);
    }

    @Override
    public Object visitSelectSingle(PrestoSqlParser.SelectSingleContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.SELECT);
        return super.visitSelectSingle(ctx);
    }

    @Override
    public Object visitDelete(PrestoSqlParser.DeleteContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.DELETE);
        return super.visitDelete(ctx);
    }
}
