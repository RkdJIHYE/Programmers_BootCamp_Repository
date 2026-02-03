public class WiseSaying {
    private int cnt ;
    private String author;
    private String content;

    public WiseSaying(int id,String content,String author){
        this.cnt = id;
        this.content = content;
        this.author = author;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}


