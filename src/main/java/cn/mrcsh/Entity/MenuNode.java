package cn.mrcsh.Entity;

import lombok.Data;

import java.util.List;

@Data
public class MenuNode<T> {

    /** 节点ID */
    private Integer id;

    /** 父节点ID：顶级节点为0 */
    private Integer parentId;

    /** 节点名称 */
    private String label;

    private T data;


    /** 子节点 */
    private List<MenuNode<T>> children;

    public MenuNode(Integer id, Integer parentId, String label, T data) {
        this.id = id;
        this.parentId = parentId;
        this.label = label;
        this.data = data;
    }
}