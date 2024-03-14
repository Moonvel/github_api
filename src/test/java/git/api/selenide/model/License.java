package git.api.selenide.model;

public class License {
    public String key;
    public String name;
    public String spdx_id;
    public String url;
    public String node_id;

    public License(String key, String name, String spdx_id, String url, String node_id) {
        this.key = key;
        this.name = name;
        this.spdx_id = spdx_id;
        this.url = url;
        this.node_id = node_id;
    }
}
