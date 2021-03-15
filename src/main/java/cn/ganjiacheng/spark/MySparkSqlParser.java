package cn.ganjiacheng.spark;

import cn.ganjiacheng.SqlParserAbstract;
import cn.ganjiacheng.antlr.PrestoSqlLexer;
import cn.ganjiacheng.antlr.PrestoSqlParser;
import cn.ganjiacheng.antlr.SparkSqlLexer;
import cn.ganjiacheng.antlr.SparkSqlParser;
import cn.ganjiacheng.enums.SqlTypeEnum;
import cn.ganjiacheng.presto.PrestoSqlTypeParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @ClassName MySparkSqlParser
 * @description:
 * @author: again
 * @Date: 2021/3/11 8:08 下午
 */
public class MySparkSqlParser extends SqlParserAbstract {

    private ParseTree getParseTree(String sql) {
        sql = sql.toUpperCase();
        CharStream input = CharStreams.fromString(sql);
        SparkSqlLexer mySqlLexer = new SparkSqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        SparkSqlParser parser = new SparkSqlParser(tokens);
        return parser.statement();
    }

    @Override
    public SqlTypeEnum parseSqlType(String sql) {
        SparkSqlTypeParser visitor = new SparkSqlTypeParser();
        visitor.visit(getParseTree(sql));
        return visitor.getSqlType();
    }

}
