package cn.ganjiacheng.hive;

import cn.ganjiacheng.antlr.HiveSqlBaseVisitor;
import cn.ganjiacheng.antlr.HiveSqlParser;
import cn.ganjiacheng.enums.SqlTypeEnum;

/**
 * @ClassName HiveSqlType
 * @description:
 * @author: again
 * @Date: 2021/3/10 4:29 下午
 */
public class HiveSqlTypeParser extends HiveSqlBaseVisitor {

    private SqlTypeEnum sqlType = null;

    private void initSqlTypeEnum(SqlTypeEnum type) {
        if(sqlType == null) {
            sqlType = type;
        }
    }

    @Override
    public Object visitCreate_table_stmt(HiveSqlParser.Create_table_stmtContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.CREATE);
        return super.visitCreate_table_stmt(ctx);
    }

    @Override
    public Object visitInsert_stmt(HiveSqlParser.Insert_stmtContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.INSERT);
        return super.visitInsert_stmt(ctx);
    }

    @Override
    public Object visitSelect_stmt(HiveSqlParser.Select_stmtContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.SELECT);
        return super.visitSelect_stmt(ctx);
    }

    @Override
    public Object visitUpdate_stmt(HiveSqlParser.Update_stmtContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.UPDATE);
        return super.visitUpdate_stmt(ctx);
    }

    @Override
    public Object visitDelete_stmt(HiveSqlParser.Delete_stmtContext ctx) {
        initSqlTypeEnum(SqlTypeEnum.DELETE);
        return super.visitDelete_stmt(ctx);
    }

    public SqlTypeEnum getSqlType() {
        return sqlType;
    }

}
