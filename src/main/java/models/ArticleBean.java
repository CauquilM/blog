package models;

/**
 *
 * @author Herbert Caffarel
 */
public class ArticleBean extends Bean {

    private int id_article;
    private String content;

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getId() {
        return id_article;
    }

    @Override
    public String toString() {
        return "ArticleBean{" + "id_article=" + id_article + ", content=" + content + '}';
    }

}
