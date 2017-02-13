package solr;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by renming.cheng on 2017/1/12.
 */
public class MsgPic {
    @Field
    private int id;

    @Field
    private String name;

    @Field
    private String url;

    @Field
    private String ad_link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAd_link() {
        return ad_link;
    }

    public void setAd_link(String ad_link) {
        this.ad_link = ad_link;
    }
}
