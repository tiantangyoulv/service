package solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

/**
 * Created by renming.cheng on 2017/1/12.
 */
public class Solr {
    private final static String URL = "http://localhost:8983/solr/jcg";
    public static SolrClient server = new HttpSolrClient(URL);

    public void query() throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        // query.setQuery("name: 最新");             //关键字查询
        // query.setQuery("name:( 最新 AND 活动)"); //多字段或关系 OR
        //query.setQuery("name:(NOT 最新 NOT 我的)");// 多字段不包含的关系 NOT
        //solrParams.set("fq", "id:[2 TO 23]");
        query.setQuery("id:[2 TO 4]");
        //query.setStart(0);//起始页
        //query.setRows(3);//每页显示数量
        QueryResponse rsp = server.query(query);
        SolrDocumentList results = rsp.getResults();
        System.out.println(results.getNumFound());//查询总条数
        for (SolrDocument doc : results) {
            System.out.println(doc);
        }
        server.close();
    }

    public void add() throws Exception {
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", "3");
        doc.addField("name", "新浪微博");
        doc.addField("url", "我有一个微博帐号名字叫做什么呢？");
        doc.addField("ad_link", "http://5.f1.dajieimg.com/n/micro_blog/T18pJvBy_T1R4cSCrK_c.png");
        UpdateResponse response = server.add(doc);
        server.commit();
        System.out.println("query time：" + response.getQTime());
        System.out.println("Elapsed Time：" + response.getElapsedTime());
        System.out.println("status：" + response.getStatus());
    }

    public void addBeans() throws Exception {
        UpdateResponse response = server.addBeans(JDBCTest.getAll());
        server.commit();
        System.out.println("query time：" + response.getQTime());
        System.out.println("Elapsed Time：" + response.getElapsedTime());
        System.out.println("status：" + response.getStatus());
    }

    public void deleteByQuery() throws Exception {
        // 删除所有的索引
        UpdateResponse response = server.deleteByQuery("*:*");
        server.commit();
        System.out.println("query time：" + response.getQTime());
        System.out.println("Elapsed Time：" + response.getElapsedTime());
        System.out.println("status：" + response.getStatus());
    }

    public void testJDBC() {
        System.out.println(JDBCTest.getAll());
    }
}
