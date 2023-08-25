package models;

/**
 * Bean pour la table article.
 *
 * @author Herbert Caffarel
 */
public class ArticleBean extends Bean {

    private Integer id_article;
    private String created;
    private String title;
    private String content;
    private int author;

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    @Override
    public Integer getId() {
        return id_article;
    }

    @Override
    public void setId(Integer id) {
        id_article = id;
    }

    @Override
    public String toString() {
        return "ArticleBean{" + "id_article=" + id_article + ", created=" + created + ", title=" + title + ", content=" + content + ", author=" + author + '}';
    }

}
