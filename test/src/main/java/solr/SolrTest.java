package solr;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renming.cheng on 2017/1/12.
 */
public class SolrTest {
    public static Solr solr = new Solr();
    @Test
    public void testQuery() throws Exception{
        solr.query();
    }
}
