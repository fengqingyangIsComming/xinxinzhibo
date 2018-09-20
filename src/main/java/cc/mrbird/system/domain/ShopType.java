package cc.mrbird.system.domain;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by WYZ on 2018/9/3.
 */
@Table(name = "dp_shop_type")
public class ShopType implements Serializable {

    private static final long serialVersionUID = -1291023491470366476L;

    private Long id;
    private String typeName;
    private String image;
    private Long language;
    private Long parentId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getLanguage() {
        return language;
    }

    public void setLanguage(Long language) {
        this.language = language;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
