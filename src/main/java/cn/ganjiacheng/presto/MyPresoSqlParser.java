package cn.ganjiacheng.presto;

import cn.ganjiacheng.SqlParserAbstract;
import cn.ganjiacheng.antlr.PrestoSqlLexer;
import cn.ganjiacheng.antlr.PrestoSqlParser;
import cn.ganjiacheng.enums.SqlTypeEnum;
import cn.ganjiacheng.mysql.MysqlSqlTypeParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @ClassName MyPresoSqlParser
 * @description:
 * @author: again
 * @Date: 2021/3/11 7:59 下午
 */
public class MyPresoSqlParser extends SqlParserAbstract {

    private ParseTree getParseTree(String sql) {
        sql = sql.toUpperCase();
        CharStream input = CharStreams.fromString(sql);
        PrestoSqlLexer mySqlLexer = new PrestoSqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        PrestoSqlParser parser = new PrestoSqlParser(tokens);
        return parser.statement();
    }

    @Override
    public SqlTypeEnum parseSqlType(String sql) {
        PrestoSqlTypeParser visitor = new PrestoSqlTypeParser();
        visitor.visit(getParseTree(sql));
        return visitor.getSqlType();
    }

}
