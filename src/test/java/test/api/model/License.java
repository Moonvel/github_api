package test.api.model;

import lombok.Data;

@Data
public class License {
    public String key;
    public String name;
    public String spdx_id;
    public String url;
    public String node_id;
}
