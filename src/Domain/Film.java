package Domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@PersistenceCapable
@XmlRootElement (name="film")
@XmlAccessorType (XmlAccessType.FIELD)

public class Film {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) 
	Long id;
	@Persistent
	String title;
	@Persistent
	int year;
	@Persistent
	String director;
	@Persistent
	int duration; //In Minutes
	@Persistent
	String credits;
	@Persistent
	String review;
	
	public Film(Long id, String title, int year, String director, int duration, String credits, String review) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.credits = credits;
		this.duration = duration;
		this.review = review;
		this.director = director;
	}

	public Film(String title, int year, String director, int duration, String credits, String review) {
		this.title = title;
		this.year = year;
		this.director = director;
		this.duration = duration;
		this.credits = credits;
		this.review = review;
	}

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getTitle() {return title;}
	public void setTitle(String name) {this.title = name;}
	
	public int getYear() {return year;}
	public void setYear(int year) {this.year = year;}
	
	public String getCredits() {return credits;}
	public void setCredits(String credits) {this.credits = credits;}
	
	public int getDuration() {return duration;}
	public void setDuration(int duration) {this.duration = duration;}
	
	public String getReview() {return review;}
	public void setReview(String review) {this.review = review;}

	public String getDirector() { return director; }
	public void setDirector(String director) {this.director = director;}

	@Override
	public String toString() {
		return "Film{" +
				"id=" + id +
				", title='" + title + '\'' +
				", year=" + year +
				", director='" + director + '\'' +
				", duration=" + duration +
				", credits='" + credits + '\'' +
				", review='" + review + '\'' +
				'}';
	}
}