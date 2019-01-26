package xmltomysql.XMLTOSQL;

import java.util.Date;

public class Publication {  
    private int id;
    private String title;
    private String key_word;
    private String content;
    private String url;
    private String reply;
    private String source;
    private String postdate;
    //private String authors;  
    


	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the key_word
	 */
	public String getKey_word() {
		return key_word;
	}
	/**
	 * @param key_word the key_word to set
	 */
	public void setKey_word(String key_word) {
		this.key_word = key_word;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	/**
	 * @return the reply
	 */
	public String getReply() {
		return reply;
	}

	/**
	 * @param reply the reply to set
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}

	/**
	 * @return the postdate
	 */
	public String getPostdate() {
		return postdate;
	}

	/**
	 * @param postdate the postdate to set
	 */
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Publication [id=" + id + ", title=" + title + ", key_word=" + key_word + ", content=" + content
				+ ", url=" + url + ", reply=" + reply + ", source=" + source + ", postdate=" + postdate + "]";
	}


 

}