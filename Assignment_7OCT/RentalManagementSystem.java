import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;

abstract class Item {

	private int identificationNumber, numberOfCopies;
	private int originalNumberOfCopies;
	private String title;

	abstract public boolean deleteItem(String title, CollectionOfItems collectionsRef);
	abstract public void checkIn(String title, CollectionOfItems collectionsRef);
	abstract public void checkOut(String title, CollectionOfItems collectionsRef);
	abstract public String toString();

	public void setIdentificationNumber(int number) {
		this.identificationNumber = number;
	}
	public void setNumberOfCopies(int number) {
		this.numberOfCopies = number;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setOriginalNumberOfCopies(int number) {
		this.originalNumberOfCopies = number;
	}
	public int getIdentificationNumber() {
		return this.identificationNumber;
	}
	public int getNumberOfCopies() {
		return this.numberOfCopies;
	}
	public String getTitle() {
		return this.title;
	}
	public int getOriginalNumberOfCopies() {
		return this.originalNumberOfCopies;
	}

}

abstract class WrittenItem extends Item {
	private String author;
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return this.author;
	}
}

class Book extends WrittenItem{

	private LinkedList<Book> booksRef;
	private Book tempBook;

	@Override
	public String toString() {
		return this.getIdentificationNumber() + " " + this.getTitle() + " " + this.getAuthor() + " " + this.getNumberOfCopies();
	}

	public boolean addItem(int identificationNumber, String title, String author, int numberofCopies, CollectionOfItems collectionsRef) {
		if(collectionsRef.getBooks() == null) {
			booksRef = new LinkedList<Book>();
			tempBook = new Book();
			tempBook.setIdentificationNumber(identificationNumber);
			tempBook.setTitle(title);
			tempBook.setAuthor(author);
			tempBook.setNumberOfCopies(numberofCopies);
			tempBook.setOriginalNumberOfCopies(numberofCopies);
			booksRef.add(tempBook);
			collectionsRef.setBooks(booksRef);
			return true;
		}
		else {
			if(searchBook(title,collectionsRef)) {
				return false;
			}
			else {
				booksRef = collectionsRef.getBooks();
				tempBook = new Book();
				tempBook.setIdentificationNumber(identificationNumber);
				tempBook.setTitle(title);
				tempBook.setAuthor(author);
				tempBook.setNumberOfCopies(numberofCopies);
				tempBook.setOriginalNumberOfCopies(numberofCopies);
				booksRef.add(tempBook);
				collectionsRef.setBooks(booksRef);
				return true;
			}
		}
	}

	@Override
	public boolean deleteItem(String title, CollectionOfItems collectionsRef) {
		booksRef = collectionsRef.getBooks();
		if(searchBook(title,collectionsRef)) {
			Book delBook = null;
			for(Book book : booksRef) {
				if(book.getTitle().equalsIgnoreCase(title)) {
					delBook = book;
					break;
				}
			}
			booksRef.remove(delBook);
			collectionsRef.setBooks(booksRef);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void checkIn(String title, CollectionOfItems collectionsRef) {
		booksRef = collectionsRef.getBooks();
		if(searchBook(title,collectionsRef)) {
			for(Book book : booksRef) {
				if(book.getTitle().equalsIgnoreCase(title)) {
					if(book.getNumberOfCopies()>0) {
						book.setNumberOfCopies(getNumberOfCopies()-1);
						System.out.println("You have successfully Checked In - " + book.getTitle());
					}
					else {
						System.out.println("Book isn't available right now");
					}
				}
			}
		} else {
			System.out.println("This book doesn't exist");
		}
	}

	@Override
	public void checkOut(String title, CollectionOfItems collectionsRef) {
		booksRef = collectionsRef.getBooks();
		if(searchBook(title,collectionsRef)) {
			for(Book book : booksRef) {
				if(book.getTitle().equalsIgnoreCase(title)) {
					if(book.getNumberOfCopies()<book.getOriginalNumberOfCopies()) {
						book.setNumberOfCopies(getNumberOfCopies()+1);
						System.out.println("You have successfully Checked Out - " + book.getTitle());
					}
					else {
						System.out.println("This book isn't ours.");
					}
				}
			}
		} else {
			System.out.println("This book doesn't exist");
		}
	}

	public boolean searchBook(String title, CollectionOfItems collectionsRef) {
		booksRef = collectionsRef.getBooks();
		if(booksRef!=null) {
			for(Book book : booksRef) {
				if(book.getTitle().equalsIgnoreCase(title)) {
					return true;
				}
			}
		}
		return false;
	}
}

class JournalPaper extends WrittenItem{

	private int yearPublished;
	private LinkedList<JournalPaper> journalsRef;
	private JournalPaper tempJournal;

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	public int getYearPublished() {
		return this.yearPublished;
	}

	@Override
	public String toString() {
		return this.getIdentificationNumber() + " " + this.getTitle() + " " + this.getAuthor() + " " + this.getNumberOfCopies() + " " + this.getYearPublished();
	}

	public boolean addItem(int identificationNumber, String title, String author, int numberofCopies, int yearPublished, CollectionOfItems collectionsRef) {
		if(collectionsRef.getJournalPapers() == null) {
			journalsRef = new LinkedList<JournalPaper>();
			tempJournal = new JournalPaper();
			tempJournal.setIdentificationNumber(identificationNumber);
			tempJournal.setTitle(title);
			tempJournal.setAuthor(author);
			tempJournal.setNumberOfCopies(numberofCopies);
			tempJournal.setOriginalNumberOfCopies(numberofCopies);
			tempJournal.setYearPublished(yearPublished);
			journalsRef.add(tempJournal);
			collectionsRef.setJournalPapers(journalsRef);
			return true;
		}
		else {
			if(searchJournal(title,collectionsRef)) {
				return false;
			}
			else {
				journalsRef = collectionsRef.getJournalPapers();
				tempJournal = new JournalPaper();
				tempJournal.setIdentificationNumber(identificationNumber);
				tempJournal.setTitle(title);
				tempJournal.setAuthor(author);
				tempJournal.setNumberOfCopies(numberofCopies);
				tempJournal.setOriginalNumberOfCopies(numberofCopies);
				tempJournal.setYearPublished(yearPublished);
				journalsRef.add(tempJournal);
				collectionsRef.setJournalPapers(journalsRef);
				return true;
			}
		}
	}

	@Override
	public boolean deleteItem(String title, CollectionOfItems collectionsRef) {
		if(searchJournal(title,collectionsRef)) {
			JournalPaper delJournal = null;
			journalsRef = collectionsRef.getJournalPapers();
			for(JournalPaper journal : journalsRef) {
				if(journal.getTitle().equalsIgnoreCase(title)) {
					delJournal = journal;
					break;
				}
			}
			journalsRef.remove(delJournal);
			collectionsRef.setJournalPapers(journalsRef);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void checkIn(String title, CollectionOfItems collectionsRef) {
		if(searchJournal(title,collectionsRef)) {
			journalsRef = collectionsRef.getJournalPapers();
			for(JournalPaper journal : journalsRef) {
				if(journal.getTitle().equalsIgnoreCase(title)) {
					if(journal.getNumberOfCopies()>0) {
						journal.setNumberOfCopies(getNumberOfCopies()-1);
						System.out.println("You have successfully Checked In - " + journal.getTitle());
					}
					else {
						System.out.println("Journal isn't available right now");
					}
				}
			}
		}
		else {
			System.out.println("This journal doesn't exist");
		}
	}

	@Override
	public void checkOut(String title, CollectionOfItems collectionsRef) {
		if(searchJournal(title,collectionsRef)) {
			journalsRef = collectionsRef.getJournalPapers();
			for(JournalPaper journal : journalsRef) {
				if(journal.getTitle().equalsIgnoreCase(title)) {
					if(journal.getNumberOfCopies()<journal.getOriginalNumberOfCopies()) {
						journal.setNumberOfCopies(getNumberOfCopies()+1);
						System.out.println("You have successfully Checked Out - " + journal.getTitle());
					}
					else {
						System.out.println("This Journal isn't ours.");
					}
				}
			}
		}
		else {
			System.out.println("This journal doesn't exist");
		}
	}

	public boolean searchJournal(String title, CollectionOfItems collectionsRef) {
		journalsRef = collectionsRef.getJournalPapers();
		if(journalsRef != null) {
			for(JournalPaper journal : journalsRef) {
				if(journal.getTitle().equalsIgnoreCase(title)) {
					return true;
				}
			}
		}
		return false;
	}

}


abstract class MediaItem extends Item {
	private int runtime;
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public int getRuntime() {
		return this.runtime;
	}
}

class Video extends MediaItem {

	private String director, genre;
	private int yearReleased;
	private LinkedList<Video> videosRef;
	private Video tempVideo;

	public void setDirector(String director) {
		this.director = director;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}
	public String getDirector() {
		return this.director;
	}
	public String getGenre() {
		return this.genre;
	}
	public int getYearReleased() {
		return this.yearReleased;
	}

	@Override
	public String toString() {
		return this.getIdentificationNumber() + " " + this.getTitle() + " " + this.getDirector() + " " + this.getGenre() + " " + this.getRuntime() + " " + this.getNumberOfCopies() + " " + this.getYearReleased();
	}

	public boolean addItem(int identificationNumber, String title, String director, String genre, int numberofCopies, int runtime, int yearReleased, CollectionOfItems collectionsRef) {
		if(collectionsRef.getVideos() == null) {
			videosRef = new LinkedList<Video>();
			tempVideo = new Video();
			tempVideo.setIdentificationNumber(identificationNumber);
			tempVideo.setTitle(title);
			tempVideo.setDirector(director);
			tempVideo.setGenre(genre);
			tempVideo.setNumberOfCopies(numberofCopies);
			tempVideo.setOriginalNumberOfCopies(numberofCopies);
			tempVideo.setRuntime(runtime);
			tempVideo.setYearReleased(yearReleased);
			videosRef.add(tempVideo);
			collectionsRef.setVideos(videosRef);
			return true;
		}
		else {
			if(searchVideo(title,collectionsRef)) {
				return false;
			}
			else {
				videosRef = collectionsRef.getVideos();
				tempVideo = new Video();
				tempVideo.setIdentificationNumber(identificationNumber);
				tempVideo.setTitle(title);
				tempVideo.setDirector(director);
				tempVideo.setGenre(genre);
				tempVideo.setNumberOfCopies(numberofCopies);
				tempVideo.setOriginalNumberOfCopies(numberofCopies);
				tempVideo.setRuntime(runtime);
				tempVideo.setYearReleased(yearReleased);
				videosRef.add(tempVideo);
				collectionsRef.setVideos(videosRef);
				return true;
			}
		}
	}

	@Override
	public boolean deleteItem(String title, CollectionOfItems collectionsRef) {
		if(searchVideo(title,collectionsRef)) {
			Video delVideo = null;
			videosRef = collectionsRef.getVideos();
			for(Video video : videosRef) {
				if(video.getTitle().equalsIgnoreCase(title)) {
					delVideo = video;
					break;
				}
			}
			videosRef.remove(delVideo);
			collectionsRef.setVideos(videosRef);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void checkIn(String title, CollectionOfItems collectionsRef) {
		if(searchVideo(title,collectionsRef)) {
			videosRef = collectionsRef.getVideos();
			for(Video video : videosRef) {
				if(video.getTitle().equalsIgnoreCase(title)) {
					if(video.getNumberOfCopies()>0) {
						video.setNumberOfCopies(getNumberOfCopies()-1);
						System.out.println("You have successfully Checked In - " + video.getTitle());
					}
					else {
						System.out.println("Video isn't available right now");
					}
				}
			}
		}
		else {
			System.out.println("This video doesn't exist");
		}
	}

	@Override
	public void checkOut(String title, CollectionOfItems collectionsRef) {
		if(searchVideo(title,collectionsRef)) {
			videosRef = collectionsRef.getVideos();
			for(Video video : videosRef) {
				if(video.getTitle().equalsIgnoreCase(title)) {
					if(video.getNumberOfCopies()<video.getOriginalNumberOfCopies()) {
						video.setNumberOfCopies(getNumberOfCopies()+1);
						System.out.println("You have successfully Checked Out- " + video.getTitle());
					}
					else {
						System.out.println("This video isn't ours");
					}
				}
			}
		}
		else {
			System.out.println("This video doesn't exist");
		}
	}

	public boolean searchVideo(String title, CollectionOfItems collectionsRef) {
		videosRef = collectionsRef.getVideos();
		if(videosRef != null) {
			for(Video video : videosRef) {
				if(video.getTitle().equalsIgnoreCase(title)) {
					return true;
				}
			}
		}
		return false;
	}

}

class CD extends MediaItem {

	private String artist, genre;
	private LinkedList<CD> cdsRef;
	private CD tempCD;

	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getArtist() {
		return this.artist;
	}
	public String getGenre() {
		return this.genre;
	}

	@Override
	public String toString() {
		return this.getIdentificationNumber() + " " + this.getTitle() + " " + this.getArtist() + " " + this.getGenre() + " " + this.getRuntime() + " " + this.getNumberOfCopies();
	}

	public boolean addItem(int identificationNumber, String title, String artist, String genre, int numberofCopies, int runtime, CollectionOfItems collectionsRef) {
		if(collectionsRef.getCDs() == null) {
			cdsRef = new LinkedList<CD>();
			tempCD = new CD();
			tempCD.setIdentificationNumber(identificationNumber);
			tempCD.setTitle(title);
			tempCD.setArtist(artist);
			tempCD.setGenre(genre);
			tempCD.setNumberOfCopies(numberofCopies);
			tempCD.setOriginalNumberOfCopies(numberofCopies);
			tempCD.setRuntime(runtime);
			cdsRef.add(tempCD);
			collectionsRef.setCDs(cdsRef);
			System.out.println(cdsRef.get(0).toString());
			return true;
		}
		else {
			if(searchCD(title,collectionsRef)) {
				return false;
			}
			else {
				cdsRef = collectionsRef.getCDs();
				tempCD = new CD();
				tempCD.setIdentificationNumber(identificationNumber);
				tempCD.setTitle(title);
				tempCD.setArtist(artist);
				tempCD.setGenre(genre);
				tempCD.setNumberOfCopies(numberofCopies);
				tempCD.setOriginalNumberOfCopies(numberofCopies);
				tempCD.setRuntime(runtime);
				cdsRef.add(tempCD);
				collectionsRef.setCDs(cdsRef);
				return true;
			}
		}
	}

	@Override
	public boolean deleteItem(String title, CollectionOfItems collectionsRef) {
		if(searchCD(title,collectionsRef)) {
			CD delCD = null;
			cdsRef = collectionsRef.getCDs();
			for(CD cd : cdsRef) {
				if(cd.getTitle().equalsIgnoreCase(title)) {
					delCD = cd;
					break;
				}
			}
			cdsRef.remove(delCD);
			collectionsRef.setCDs(cdsRef);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void checkIn(String title, CollectionOfItems collectionsRef) {
		if(searchCD(title,collectionsRef)) {
			cdsRef = collectionsRef.getCDs();
			for(CD cd : cdsRef) {
				if(cd.getTitle().equalsIgnoreCase(title)) {
					if(cd.getNumberOfCopies()>0) {
						cd.setNumberOfCopies(getNumberOfCopies()-1);
						System.out.println("You have successfully Checked In - " + cd.getTitle());
					}
					else {
						System.out.println("CD isn't available right now");
					}
				}
			}
		}
		else {
			System.out.println("This cd doesn't exist");
		}
	}

	@Override
	public void checkOut(String title, CollectionOfItems collectionsRef) {
		if(searchCD(title,collectionsRef)) {
			cdsRef = collectionsRef.getCDs();
			for(CD cd : cdsRef) {
				if(cd.getTitle().equalsIgnoreCase(title)) {
					if(cd.getNumberOfCopies()<cd.getOriginalNumberOfCopies()) {
						cd.setNumberOfCopies(getNumberOfCopies()-1);
						System.out.println("You have successfully Checked In - " + cd.getTitle());
					}
					else {
						System.out.println("This CD isn't ours");
					}
				}
			}
		}
		else {
			System.out.println("This cd doesn't exist");
		}
	}

	public boolean searchCD(String title, CollectionOfItems collectionsRef) {
		cdsRef = collectionsRef.getCDs();
		if(cdsRef != null) {
			for(CD cd : cdsRef) {
				if(cd.getTitle().equalsIgnoreCase(title)) {
					return true;
				}
			}
		}
		return false;
	}

}

class CollectionOfItems{

	private LinkedList<Book> books;
	private LinkedList<JournalPaper> journalPapers;
	private LinkedList<Video> videos;
	private LinkedList<CD> cds;

	public void setBooks(LinkedList<Book> books) {
		this.books = books;
	}
	public LinkedList<Book> getBooks() {
		return this.books;
	}
	public void setJournalPapers(LinkedList<JournalPaper> journalPapers) {
		this.journalPapers = journalPapers;
	}
	public LinkedList<JournalPaper> getJournalPapers() {
		return this.journalPapers;
	}
	public void setVideos(LinkedList<Video> videos) {
		this.videos = videos;
	}
	public LinkedList<Video> getVideos() {
		return this.videos;
	}
	public void setCDs(LinkedList<CD> cds) {
		this.videos = videos;
	}
	public LinkedList<CD> getCDs() {
		return this.cds;
	}

}

class RentalManagementSystem {

	static int tempIdentificationNumber, tempNumberOfCopies, tempYearPublished, tempRuntime, tempYearReleased;
	static String tempTitle, tempAuthor, tempArtist, tempDirector, tempGenre;

	static void displayBooks(CollectionOfItems collectionsRef) {
		LinkedList<Book> tempBookDisplay = collectionsRef.getBooks();
		if(tempBookDisplay != null) {
			System.out.println("IdentificationNumber Title Author NumberofCopies");
			for(Book book : tempBookDisplay) {
				System.out.println(book.toString());
			}
		}
		else {
			System.out.println("Sorry...Nothing available right now");
		}
	}

	static void displayJournalPapers(CollectionOfItems collectionsRef) {
		LinkedList<JournalPaper> tempJournalDisplay = collectionsRef.getJournalPapers();
		if(tempJournalDisplay != null) {
			System.out.println("IdentificationNumber Title Author NumberofCopies YearPublished");
			for(JournalPaper journal : tempJournalDisplay) {
				System.out.println(journal.toString());
			}
		}
		else {
			System.out.println("Sorry...Nothing available right now");
		}

	}
	static void displayVideos(CollectionOfItems collectionsRef) {
		LinkedList<Video> tempVideoDisplay = collectionsRef.getVideos();
		if(tempVideoDisplay != null) {
			System.out.println("IdentificationNumber Title Director Genre Runtime NumberofCopies YearReleased");
			for(Video video : tempVideoDisplay) {
				System.out.println(video.toString());
			}
		}
		else {
			System.out.println("Sorry...Nothing available right now");
		}
	}
	static void displayCDs(CollectionOfItems collectionsRef) {
		LinkedList<CD> tempCDDisplay = collectionsRef.getCDs();
		if(tempCDDisplay != null) {
			System.out.println("IdentificationNumber Title Artist Genre Runtime NumberofCopies");
			for(CD cd : tempCDDisplay) {
				System.out.println(cd.toString());
			}
		}
		else {
			System.out.println("Sorry...Nothing available right now");
		}
	}

	static void addBook(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the identificationNumber :");
		RentalManagementSystem.tempIdentificationNumber = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the title :");
		RentalManagementSystem.tempTitle = scan.nextLine();
		System.out.println("Enter the Author :");
		RentalManagementSystem.tempAuthor = scan.nextLine();
		System.out.println("Enter the numberofCopies :");
		RentalManagementSystem.tempNumberOfCopies = scan.nextInt();
		scan.nextLine();
		if(new Book().addItem(RentalManagementSystem.tempIdentificationNumber,RentalManagementSystem.tempTitle,RentalManagementSystem.tempAuthor,RentalManagementSystem.tempNumberOfCopies, collectionsRef)){
			System.out.println("Book added successfully");
		}
		else {
			System.out.println("Book is already present in the list");
		}
	}

	static void addJournal(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the identificationNumber :");
		RentalManagementSystem.tempIdentificationNumber = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the title :");
		RentalManagementSystem.tempTitle = scan.nextLine();
		System.out.println("Enter the Author :");
		RentalManagementSystem.tempAuthor = scan.nextLine();
		System.out.println("Enter the numberofCopies :");
		RentalManagementSystem.tempNumberOfCopies = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the year in which it got published");
		RentalManagementSystem.tempYearPublished = scan.nextInt();
		scan.nextLine();
		if(new JournalPaper().addItem(RentalManagementSystem.tempIdentificationNumber,RentalManagementSystem.tempTitle,RentalManagementSystem.tempAuthor,RentalManagementSystem.tempNumberOfCopies,RentalManagementSystem.tempYearPublished, collectionsRef)){
			System.out.println("Journal added successfully");
		}
		else {
			System.out.println("Journal is already present in the list");
		}
	}

	static void addVideo(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the identificationNumber :");
		RentalManagementSystem.tempIdentificationNumber = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the title :");
		RentalManagementSystem.tempTitle = scan.nextLine();
		System.out.println("Enter the Director :");
		RentalManagementSystem.tempDirector = scan.nextLine();
		System.out.println("Enter the Genre :");
		RentalManagementSystem.tempGenre = scan.nextLine();
		System.out.println("Enter the numberofCopies :");
		RentalManagementSystem.tempNumberOfCopies = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the runtime of the video");
		RentalManagementSystem.tempRuntime = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the year in which video got Released");
		RentalManagementSystem.tempYearReleased = scan.nextInt();
		scan.nextLine();
		if(new Video().addItem(RentalManagementSystem.tempIdentificationNumber,RentalManagementSystem.tempTitle,RentalManagementSystem.tempDirector,RentalManagementSystem.tempGenre,RentalManagementSystem.tempNumberOfCopies,RentalManagementSystem.tempRuntime,RentalManagementSystem.tempYearReleased, collectionsRef)) {
			System.out.println("Video added successfully");
		}
		else {
			System.out.println("Video is already present in the list");
		}
	}

	static void addCD(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the identificationNumber :");
		RentalManagementSystem.tempIdentificationNumber = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the title :");
		RentalManagementSystem.tempTitle = scan.nextLine();
		System.out.println("Enter the Artist :");
		RentalManagementSystem.tempArtist = scan.nextLine();
		System.out.println("Enter the Genre :");
		RentalManagementSystem.tempGenre = scan.nextLine();
		System.out.println("Enter the numberofCopies :");
		RentalManagementSystem.tempNumberOfCopies = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the runtime of the video");
		RentalManagementSystem.tempRuntime = scan.nextInt();
		scan.nextLine();
		if(new CD().addItem(RentalManagementSystem.tempIdentificationNumber,RentalManagementSystem.tempTitle,RentalManagementSystem.tempArtist,RentalManagementSystem.tempGenre,RentalManagementSystem.tempNumberOfCopies,RentalManagementSystem.tempRuntime, collectionsRef)) {
			System.out.println("CD added successfully");
		}
		else {
			System.out.println("CD is already present in the list");
		}		
	}


	static void deleteBook(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the title of the book you wanna delete");
		if(new Book().deleteItem(scan.nextLine(), collectionsRef)) {
			System.out.println("Book got deleted successfully");
		}
		else {
			System.out.println("Book doesn't exist");
		}
	}

	static void deleteJournal(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the title of the Journal you wanna delete");
		if(new JournalPaper().deleteItem(scan.nextLine(), collectionsRef)) {
			System.out.println("Journal got deleted successfully");
		}
		else {
			System.out.println("Journal doesn't exist");
		}
	}

	static void deleteVideo(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the title of the Video you wanna delete");
		if(new Video().deleteItem(scan.nextLine(), collectionsRef)) {
			System.out.println("Video got deleted successfully");
		}
		else {
			System.out.println("Video doesn't exist");
		}
	}

	static void deleteCD(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the title of the CD you wanna delete");
		if(new CD().deleteItem(scan.nextLine(), collectionsRef)) {
			System.out.println("CD got deleted successfully");
		}
		else {
			System.out.println("CD doesn't exist");
		}
	}

	static void searchMainBook(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the title of the book you wanna search");
		if(new Book().searchBook(scan.nextLine(), collectionsRef)) {
			System.out.println("Yeah it's available");
		}
		else {
			System.out.println("No such book exists");
		}		
	}

	static void searchMainJournal(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the title of the Journal you wanna search");
		if(new JournalPaper().searchJournal(scan.nextLine(), collectionsRef)) {
			System.out.println("Yeah it's available");
		}
		else {
			System.out.println("No such journal exists");
		}
	}

	static void searchMainVideo(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the title of the video you wanna search");
		if(new Video().searchVideo(scan.nextLine(), collectionsRef)) {
			System.out.println("Yeah it's available");
		}
		else {
			System.out.println("No such video exists");
		}
	}

	static void searchMainCD(Scanner scan, CollectionOfItems collectionsRef) {

		System.out.println("Enter the title of the CD you wanna search");
		if(new CD().searchCD(scan.nextLine(), collectionsRef)) {
			System.out.println("Yeah it's available");
		}
		else {
			System.out.println("No such CD exists");
		}
	}

	static void displayOptions(String action) {

		System.out.println("Enter the Item you wanna " + action);
		System.out.println("1. Book");
		System.out.println("2. JournalPaper");
		System.out.println("3. Video");
		System.out.println("4. CD");
	}
	public static void main(String[] args) {
		
		CollectionOfItems collectionsRef = new CollectionOfItems();
		Scanner scan = new Scanner(System.in);
		boolean flag;
		do {
			flag = false;
			System.out.println("Enter the option number :");
			System.out.println("1. Display");
			System.out.println("2. Add Item");
			System.out.println("3. Delete Item");
			System.out.println("4. Check In");
			System.out.println("5. Check Out");
			System.out.println("6. Search An Item");

			int option = scan.nextInt();
			scan.nextLine();
			switch(option) {

				case 1: 
				RentalManagementSystem.displayOptions("Display");

				int displayOption = scan.nextInt();
				scan.nextLine();

				switch(displayOption) {
					case 1:
					RentalManagementSystem.displayBooks(collectionsRef);
					break;
					case 2:
					RentalManagementSystem.displayJournalPapers(collectionsRef);
					break;
					case 3 :
					RentalManagementSystem.displayVideos(collectionsRef);
					break;
					case 4:
					RentalManagementSystem.displayCDs(collectionsRef);
					break;
					default:
					System.out.println("You have entered wrong option");
					break;
				}
				break;
				case 2:
				RentalManagementSystem.displayOptions("Add");

				int addOption = scan.nextInt();
				scan.nextLine();

				switch(addOption) {
					case 1:
					RentalManagementSystem.addBook(scan,collectionsRef);
					break;
					case 2:
					RentalManagementSystem.addJournal(scan,collectionsRef);
					break;
					case 3 :
					RentalManagementSystem.addVideo(scan,collectionsRef);
					break;
					case 4:
					RentalManagementSystem.addCD(scan,collectionsRef);
					break;
					default:
					System.out.println("You have entered wrong option");
					break;
				}
				break;
				case 3:
				RentalManagementSystem.displayOptions("Delete");

				int delOption = scan.nextInt();
				scan.nextLine();

				switch(delOption) {
					case 1:
					RentalManagementSystem.deleteBook(scan,collectionsRef);
					break;
					case 2:
					RentalManagementSystem.deleteJournal(scan,collectionsRef);
					break;
					case 3:
					RentalManagementSystem.deleteVideo(scan,collectionsRef);
					break;
					case 4:
					RentalManagementSystem.deleteCD(scan,collectionsRef);
					break;
					default:
					System.out.println("You have entered wrong option");
					break;
				}
				break;
				case 4: 
				RentalManagementSystem.displayOptions("Check In");

				int checkInOption = scan.nextInt();
				scan.nextLine();

				switch(checkInOption) {
					case 1:
					System.out.println("Enter the title of the book you wanna check in");
					new Book().checkIn(scan.nextLine(),collectionsRef);
					break;
					case 2:
					System.out.println("Enter the title of the Journal you wanna check in");
					new JournalPaper().checkIn(scan.nextLine(),collectionsRef);
					break;
					case 3:
					System.out.println("Enter the title of the Video you wanna check in");
					new Video().checkIn(scan.nextLine(),collectionsRef);
					break;
					case 4:
					System.out.println("Enter the title of the CD you wanna check in");
					new CD().checkIn(scan.nextLine(),collectionsRef);
					break;
					default:
					System.out.println("You have entered wrong option");
					break;
				}
				break;
				case 5:
				RentalManagementSystem.displayOptions("Check Out");

				int checkOutOption = scan.nextInt();
				scan.nextLine();

				switch(checkOutOption) {
					case 1:
					System.out.println("Enter the title of the book you wanna check out");
					new Book().checkOut(scan.nextLine(),collectionsRef);
					break;
					case 2:
					System.out.println("Enter the title of the Journal you wanna check out");
					new JournalPaper().checkOut(scan.nextLine(),collectionsRef);
					break;
					case 3:
					System.out.println("Enter the title of the Video you wanna check out");
					new Video().checkOut(scan.nextLine(),collectionsRef);
					break;
					case 4:
					System.out.println("Enter the title of the CD you wanna check out");
					new CD().checkOut(scan.nextLine(),collectionsRef);
					break;
					default:
					System.out.println("You have entered wrong option");
					break;

				}
				break;
				case 6:
				RentalManagementSystem.displayOptions("Search");

				int searchOption = scan.nextInt();
				scan.nextLine();

				switch(searchOption) {
					case 1: 
					RentalManagementSystem.searchMainBook(scan,collectionsRef);
					break;
					case 2:
					RentalManagementSystem.searchMainJournal(scan,collectionsRef);
					break;
					case 3:
					RentalManagementSystem.searchMainVideo(scan,collectionsRef);
					break;
					case 4:
					RentalManagementSystem.searchMainCD(scan,collectionsRef);
					break;
					default:
					System.out.println("You have entered wrong option");
					break;
				}
				break;
				default:
				System.out.println("You have entered wrong option");
				break;
			}
			System.out.println("You wanna continue....Yes/No");
			String consent = scan.nextLine();
			if(consent.equalsIgnoreCase("Yes")) {
				flag = true;
			}
		}while(flag);
	}
}