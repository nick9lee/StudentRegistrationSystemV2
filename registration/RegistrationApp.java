package registration;
import java.util.Scanner;

/**
 * the front end of the system
 * @author Nicholas Lee
 *
 */
public class RegistrationApp {
	//private Scanner scan;
	private Student student;
	private CourseCatalogue cat;
	
	public RegistrationApp() {
		//scan = new Scanner(System.in);
		cat = new CourseCatalogue();
		student = new Student("Nick", 30061802);  
	}

	/**
	 * returns a list of all the courses the student is enrolled in
	 * @return
	 */
	public String viewStudentCourses() {
		return student.printStudentCourses();
	}
	
	/**
	 * prints a courses info
	 * @param course
	 */
	public void printCourse(Course course) {
		if(course == null) {
			System.out.println("course not found");
			return;
		}
		System.out.println(course.getCourseName() +" "+ course.getCourseNum());
	}
	
	/**
	 * tries to find a course froms a given name and course id
	 * @param name
	 * @param id
	 * @return
	 */
	public String findCourse(String name, int id){
		String result = "";
		Course course = cat.searchCat(name, id);
		if(course!= null)
			result = course.toString();
		else
			result = "The course "+name+" "+id+" was not found in the catalogue";
		result += "\0";
		return result;
	}
	
	/**
	 * adds a course to students list of enrolled courses
	 * @param course
	 * @param sec
	 * @return
	 */
	public String addCourse(Course course, int sec) {
		if(course != null)
			return student.addCourse(course, sec)+"\0";
		else
			return "The course specified was not found\0";
	}
	
	/**
	 * removes course from list of students enrolled courses
	 * @param name
	 * @param id
	 * @return
	 */
	public String removeCourse(String name, int id) {
		String result = student.removeCourse(name, id);
		result+="\0";
		return result;
	}
	
	/**
	 * returns info with all of the courses in the catalog
	 * @return
	 */
	public String viewAllCourses() {
		return cat.toString();
	}


	public CourseCatalogue getCat() {
		return cat;
	}


	public void setCat(CourseCatalogue cat) {
		this.cat = cat;
	}

}
