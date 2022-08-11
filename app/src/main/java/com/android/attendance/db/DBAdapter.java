package com.android.attendance.db;

import java.util.ArrayList;

import com.android.attendance.bean.AttendanceBean;
import com.android.attendance.bean.AttendanceSessionBean;
import com.android.attendance.bean.FacultyBean;
import com.android.attendance.bean.StudentBean;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "Attendance";

	// Contacts table name
	private static final String FACULTY_INFO_TABLE = "faculty_table";
	private static final String STUDENT_INFO_TABLE = "student_table";
	private static final String ATTENDANCE_SESSION_TABLE = "attendance_session_table";
	private static final String ATTENDANCE_TABLE = "attendance_table";


	// Contacts Table Columns names
	private static final String KEY_FACULTY_ID = "faculty_id";
	private static final String KEY_FACULTY_FIRSTNAME = "faculty_firstname";
	private static final String KEY_FACULTY_LASTNAME = "faculty_Lastname";
	private static final String KEY_FACULTY_MO_NO = "faculty_mobilenumber";
	private static final String KEY_FACULTY_ADDRESS = "faculty_address";
	private static final String KEY_FACULTY_USERNAME = "faculty_username";
	private static final String KEY_FACULTY_PASSWORD = "faculty_password";

	private static final String KEY_STUDENT_ID = "student_id";
	private static final String KEY_STUDENT_FIRSTNAME = "student_firstname";
	private static final String KEY_STUDENT_LASTNAME = "student_lastname";
	private static final String KEY_STUDENT_MO_NO = "student_mobilenumber";
	private static final String KEY_STUDENT_ADDRESS = "student_address";
	private static final String KEY_STUDENT_DEPARTMENT = "student_department";
	private static final String KEY_STUDENT_CLASS = "student_class";

	private static final String KEY_ATTENDANCE_SESSION_ID = "attendance_session_id";
	private static final String KEY_ATTENDANCE_SESSION_FACULTY_ID = "attendance_session_faculty_id";
	private static final String KEY_ATTENDANCE_SESSION_DEPARTMENT = "attendance_session_department";
	private static final String KEY_ATTENDANCE_SESSION_CLASS = "attendance_session_class";
	private static final String KEY_ATTENDANCE_SESSION_DATE = "attendance_session_date";
	private static final String KEY_ATTENDANCE_SESSION_SUBJECT = "attendance_session_subject";

	private static final String KEY_SESSION_ID = "attendance_session_id";
	private static final String KEY_ATTENDANCE_STUDENT_ID = "attendance_student_id";
	private static final String KEY_ATTENDANCE_STATUS = "attendance_status";
	private StudentBean studentBean;


	public DBAdapter(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}


	@Override

	public void onCreate(SQLiteDatabase db) {
		String queryFaculty="CREATE TABLE "+ FACULTY_INFO_TABLE +" (" +
				KEY_FACULTY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				KEY_FACULTY_FIRSTNAME + " TEXT, " + 
				KEY_FACULTY_LASTNAME + " TEXT, " +
				KEY_FACULTY_MO_NO + " TEXT, " +
				KEY_FACULTY_ADDRESS + " TEXT," +
				KEY_FACULTY_USERNAME + " TEXT," +
				KEY_FACULTY_PASSWORD + " TEXT " + ")";
		Log.d("queryFaculty",queryFaculty);


		String queryStudent="CREATE TABLE "+ STUDENT_INFO_TABLE +" (" +
				KEY_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				KEY_STUDENT_FIRSTNAME + " TEXT, " + 
				KEY_STUDENT_LASTNAME + " TEXT, " +
				KEY_STUDENT_MO_NO + " TEXT, " +
				KEY_STUDENT_ADDRESS + " TEXT," +
				KEY_STUDENT_DEPARTMENT + " TEXT," +
				KEY_STUDENT_CLASS + " TEXT " + ")";
		Log.d("queryStudent",queryStudent );


		String queryAttendanceSession="CREATE TABLE "+ ATTENDANCE_SESSION_TABLE +" (" +
				KEY_ATTENDANCE_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				KEY_ATTENDANCE_SESSION_FACULTY_ID + " INTEGER, " + 
				KEY_ATTENDANCE_SESSION_DEPARTMENT + " TEXT, " +
				KEY_ATTENDANCE_SESSION_CLASS + " TEXT, " +
				KEY_ATTENDANCE_SESSION_DATE + " DATE," +
				KEY_ATTENDANCE_SESSION_SUBJECT + " TEXT" + ")";
		Log.d("queryAttendanceSession",queryAttendanceSession );


		String queryAttendance="CREATE TABLE "+ ATTENDANCE_TABLE +" (" +
				KEY_SESSION_ID + " INTEGER, " +
				KEY_ATTENDANCE_STUDENT_ID + " INTEGER, " +
				KEY_ATTENDANCE_STATUS + " TEXT " + ")";
		Log.d("queryAttendance",queryAttendance );


		try
		{
			db.execSQL(queryFaculty);
			db.execSQL(queryStudent);
			db.execSQL(queryAttendanceSession);
			db.execSQL(queryAttendance);
		}
		catch (Exception e) {
			e.printStackTrace();
			Log.e("Exception", e.getMessage());
		}

	} 


	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		String queryFaculty="CREATE TABLE "+ FACULTY_INFO_TABLE +" (" +
				KEY_FACULTY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				KEY_FACULTY_FIRSTNAME + " TEXT, " + 
				KEY_FACULTY_LASTNAME + " TEXT, " +
				KEY_FACULTY_MO_NO + " TEXT, " +
				KEY_FACULTY_ADDRESS + " TEXT," +
				KEY_FACULTY_USERNAME + " TEXT," +
				KEY_FACULTY_PASSWORD + " TEXT " + ")";
		Log.d("queryFaculty",queryFaculty);


		String queryStudent="CREATE TABLE "+ STUDENT_INFO_TABLE +" (" +
				KEY_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				KEY_STUDENT_FIRSTNAME + " TEXT, " + 
				KEY_STUDENT_LASTNAME + " TEXT, " +
				KEY_STUDENT_MO_NO + " TEXT, " +
				KEY_STUDENT_ADDRESS + " TEXT," +
				KEY_STUDENT_DEPARTMENT + " TEXT," +
				KEY_STUDENT_CLASS + " TEXT " + ")";
		Log.d("queryStudent",queryStudent );


		String queryAttendanceSession="CREATE TABLE "+ ATTENDANCE_SESSION_TABLE +" (" +
				KEY_ATTENDANCE_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				KEY_ATTENDANCE_SESSION_FACULTY_ID + " INTEGER, " + 
				KEY_ATTENDANCE_SESSION_DEPARTMENT + " TEXT, " +
				KEY_ATTENDANCE_SESSION_CLASS + " TEXT, " +
				KEY_ATTENDANCE_SESSION_DATE + " TEXT," +
				KEY_ATTENDANCE_SESSION_SUBJECT + " TEXT" +")";
		Log.d("queryAttendanceSession",queryAttendanceSession );


		String queryAttendance="CREATE TABLE "+ ATTENDANCE_TABLE +" (" +
				KEY_SESSION_ID + " INTEGER, " +
				KEY_ATTENDANCE_STUDENT_ID + " INTEGER, " +
				KEY_ATTENDANCE_STATUS + " TEXT " + ")";
		Log.d("queryAttendance",queryAttendance );

		try
		{
			db.execSQL(queryFaculty);
			db.execSQL(queryStudent);
			db.execSQL(queryAttendanceSession);
			db.execSQL(queryAttendance);
		}
		catch (Exception e) {
			e.printStackTrace();
			Log.e("Exception", e.getMessage());
		}		
	}

	//facult crud

	public void addFac(FacultyBean facultyBean) {
		SQLiteDatabase db = this.getWritableDatabase();

		String sql = "INSERT INTO faculty_table (faculty_firstname,faculty_Lastname,faculty_username,faculty_password) VALUES('Sudhir','Kumar Pandey','sudhir','sudhir'),('Shambhu','Shankar Bharti','sambhu','sambhu'),('Sushil','Kumar','sushil','sushil'),('Preetam','Amrit','preetam','preetam'),('Sams','Tabrej','sams','sams')";
		db.execSQL(sql);
		db.close();
	}
	public void addFaculty(FacultyBean facultyBean) {
		SQLiteDatabase db = this.getWritableDatabase();

		String query = "INSERT INTO faculty_table (faculty_firstname,faculty_Lastname,faculty_mobilenumber,faculty_address,faculty_username,faculty_password) values ('"+ 
				facultyBean.getFaculty_firstname()+"', '"+
				facultyBean.getFaculty_lastname()+"', '"+
				facultyBean.getFaculty_mobilenumber()+"', '"+
				facultyBean.getFaculty_address()+"', '"+
				facultyBean.getFaculty_username()+"', '"+
				facultyBean.getFaculty_password()+"')";
		Log.d("query", query);
		db.execSQL(query);
		db.close();
	}

	public FacultyBean validateFaculty(String userName,String password)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		String query = "SELECT * FROM faculty_table where faculty_username='"+userName+"' and faculty_password='"+password+"'";
		Cursor cursor = db.rawQuery(query, null);

		if(cursor.moveToFirst()) 
		{
			
				FacultyBean facultyBean = new FacultyBean();
				facultyBean.setFaculty_id(Integer.parseInt(cursor.getString(0)));
				facultyBean.setFaculty_firstname(cursor.getString(1));
				facultyBean.setFaculty_lastname(cursor.getString(2));
				facultyBean.setFaculty_mobilenumber(cursor.getString(3));
				facultyBean.setFaculty_address(cursor.getString(4));
				facultyBean.setFaculty_username(cursor.getString(5));
				facultyBean.setFaculty_password(cursor.getString(6));
				return facultyBean;
		}
		return null;
	}

	public ArrayList<FacultyBean> getAllFaculty()
	{
		Log.d("in get all","in get all" );
		ArrayList<FacultyBean> list = new ArrayList<FacultyBean>();

		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT * FROM faculty_table";
		Cursor cursor = db.rawQuery(query, null);

		if(cursor.moveToFirst()) 
		{
			do{
				FacultyBean facultyBean = new FacultyBean();
				facultyBean.setFaculty_id(Integer.parseInt(cursor.getString(0)));
				facultyBean.setFaculty_firstname(cursor.getString(1));
				facultyBean.setFaculty_lastname(cursor.getString(2));
				facultyBean.setFaculty_mobilenumber(cursor.getString(3));
				facultyBean.setFaculty_address(cursor.getString(4));
				facultyBean.setFaculty_username(cursor.getString(5));
				facultyBean.setFaculty_password(cursor.getString(6));
				list.add(facultyBean);

			}while(cursor.moveToNext());
		}
		return list;
	}

	public void deleteFaculty(int facultyId) {
		SQLiteDatabase db = this.getWritableDatabase();

		String query = "DELETE FROM faculty_table WHERE faculty_id="+facultyId ;

		Log.d("query", query);
		db.execSQL(query);
		db.close();
	}

	//student crud
	public void addStudent(StudentBean studentBean) {
		SQLiteDatabase db = this.getWritableDatabase();

//		String sql = "INSERT or replace INTO student_table(student_firstname,student_lastname,student_address,student_department,student_class) VALUES('apple1234','kumar','18105117009','cse','4th')";
//		db.execSQL(sql);

		String query = "INSERT INTO student_table (student_firstname,student_lastname,student_mobilenumber,student_address,student_department,student_class) values ('"+ 
				studentBean.getStudent_firstname()+"', '"+
				studentBean.getStudent_lastname()+"','"+
				studentBean.getStudent_mobilenumber()+"', '"+
				studentBean.getStudent_address()+"', '"+
				studentBean.getStudent_department()+"', '"+
				studentBean.getStudent_class()+"')";


		Log.d("query", query);
		db.execSQL(query);
		db.close();
	}

	public void addStudents(StudentBean studentBean) {
		this.studentBean = studentBean;
		SQLiteDatabase db = this.getWritableDatabase();

		String sql = "INSERT or replace INTO student_table(student_firstname,student_lastname,student_address,student_department,student_class) VALUES('Rajeev','Kumar Singh','18105117001','cse','4th'),('Mayank','Kumar','18105117002','cse','4th'),('Rakesh','Manjhi','18105117003','cse','4th'),('Zeba','Irfan','18105117004','cse','4th'),('Khushboo','Kumari','18105117005','cse','4th'),('Nishi','Kumari','18105117006','cse','4th'),('Md.','Shahnawaz','18105117007','cse','4th'),('Subesh','Kumar','18105117008','cse','4th'),('Puja','Kumari','18105117009','cse','4th'),('Vishakha','Singh','18105117010','cse','4th'),('Shristi','Kashyap','18105117011','cse','4th'),('Ratan','Kumar','18105117012','cse','4th'),('Sumit','Kumar','18105117013','cse','4th'),('Ashutosh','Kumar Jha','18105117014','cse','4th'),('Shubham','Kumar','18105117015','cse','4th'),('Himanshu','Raj','18105117016','cse','4th'),('Divesh','Jaiswal','18105117017','cse','4th'),('Amar','Kumar','18105117018','cse','4th'),('Vikash','Kumar','18105117019','cse','4th'),('Dhiraj','Kumar','18105117020','cse','4th'),('Shivam','Kumar','18105117021','cse','4th'),('Vedant','Kumar','18105117022','cse','4th'),('Anisha','Kumari','18105117023','cse','4th'),('Vandana','Kumari','18105117024','cse','4th'),('Shristi','','18105117025','cse','4th'),('Ashish','Kumar','18105117026','cse','4th'),('Anshu','Shree Shah','18105117027','cse','4th'),('Aniket','Shandilya','18105117028','cse','4th'),('Aniket','Kumar','18105117029','cse','4th'),('Vikash','Kumar Chaudhary','18105117030','cse','4th'),('Surbhi','Kumari','18105117031','cse','4th'),('Birendra','Kumar Pal','18105117032','cse','4th'),('Ankit','Kumar','18105117033','cse','4th'),('Aalekh','Singh','18105117034','cse','4th'),('Animesh','Ranjan','18105117035','cse','4th'),('Aryan','Aman','18105117036','cse','4th'),('Himanshu','Kumar','18105117037','cse','4th'),('Manjali','Kumari Patel','18105117038','cse','4th'),('Mamta','Kumari','18105117039','cse','4th'),('Ritika','','18105117040','cse','4th'),('Bishnu','Kumar','18105117041','cse','4th'),('Akash','Gupta','18105117042','cse','4th'),('Rakesh','Kumar Gupta','18105117043','cse','4th'),('Rohit','Kumar','18105117044','cse','4th'),('Raju','Kumar','18105117045','cse','4th'),('Vikram','Rathor','18105117046','cse','4th'),('Vivek','Kumar','18105117047','cse','4th'),('Vivek','Kumar','18105117048','cse','4th'),('Sumit','Raj','18105117049','cse','4th'),('Shubhash','Kumar','18105117050','cse','4th'),('Divyanshu','Darshan','18105117051','cse','4th')";
		String s = "INSERT or replace INTO student_table(student_firstname,student_lastname,student_address,student_department,student_class) VALUES('Supriya','Keshri','20105117001','cse','2nd'),\n" +
				"('Akash','Kumar','20105117002','cse','2nd'),\n" +
				"('Aakash','Kumar','20105117003','cse','2nd'),\n" +
				"('Raja','Kumar','20105117004','cse','2nd'),\n" +
				"('Vishal','Kumar Roy','20105117005','cse','2nd'),\n" +
				"('Ujjawal','Mishra','20105117006','cse','2nd'),\n" +
				"('Sahil','Saurav','20105117007','cse','2nd'),\n" +
				"('Akash','Sneha','20105117008','cse','2nd'),\n" +
				"('Ajay','Ram','20105117009','cse','2nd'),\n" +
				"('Bhaskar','Kumar','20105117010','cse','2nd'),\n" +
				"('Biresh','Kumar','20105117012','cse','2nd'),\n" +
				"('Ruchi','Kumari','20105117013','cse','2nd'),\n" +
				"('Ritik','Kumar Raushan','20105117014','cse','2nd'),\n" +
				"('Avnish','Kumar Aman','20105117015','cse','2nd'),\n" +
				"('Abhishek','Kumar','20105117016','cse','2nd'),\n" +
				"('Nitesh','Kumar','20105117017','cse','2nd'),\n" +
				"('Sachin','Kumar','20105117018','cse','2nd'),\n" +
				"('Jyoti','Arya','20105117019','cse','2nd'),\n" +
				"('Sonali','Kumari','20105117020','cse','2nd'),\n" +
				"('Aditya','Kumar','20105117021','cse','2nd'),\n" +
				"('Manish','Kumar','20105117022','cse','2nd'),\n" +
				"('Kaushikee','Kumari','20105117023','cse','2nd'),\n" +
				"('Akash','Kumar','20105117024','cse','2nd'),\n" +
				"('MD','Atur Rahman','20105117025','cse','2nd'),\n" +
				"('Sushmita','Kumari','20105117026','cse','2nd'),\n" +
				"('Kishan','Kumar Singh','20105117027','cse','2nd'),\n" +
				"('Sadanand','Kumar','20105117028','cse','2nd'),\n" +
				"('Snehal','Parshant','20105117029','cse','2nd'),\n" +
				"('Usma','Enan','20105117030','cse','2nd'),\n" +
				"('MD','Tabrej Ansari','20105117031','cse','2nd'),\n" +
				"('Abhishek','Kumar','20105117032','cse','2nd'),\n" +
				"('Gaurav','Raj','20105117033','cse','2nd'),\n" +
				"('Karnika','Singh','20105117034','cse','2nd'),\n" +
				"('Vivek','Kumar Soni','20105117035','cse','2nd'),\n" +
				"('Aditya','Raj','20105117036','cse','2nd'),\n" +
				"('Ananya','Sinha','20105117037','cse','2nd'),\n" +
				"('MD','Sahbaz','20105117038','cse','2nd'),\n" +
				"('Jay','Vikash Kumar','20105117039','cse','2nd'),\n" +
				"('Anshuman','Kumar','20105117040','cse','2nd'),\n" +
				"('Govind','Pandey','20105117041','cse','2nd'),\n" +
				"('Ndihi','Kumari','20105117042','cse','2nd'),\n" +
				"('Rohit','Raj','20105117043','cse','2nd'),\n" +
				"('Nitin','Kumar','20105117044','cse','2nd'),\n" +
				"('Ankit','Kumar Raj','20105117045','cse','2nd'),\n" +
				"('Sanjeev','Kumar','20105117046','cse','2nd'),\n" +
				"('Ankit','Kumar','20105117047','cse','2nd'),\n" +
				"('Raushan','Kumar','20105117048','cse','2nd'),\n" +
				"('Vishal','Kumar','20105117049','cse','2nd'),\n" +
				"('Vicky','Kumar','20105117050','cse','2nd'),\n" +
				"('Tejash','Vats','20105117051','cse','2nd'),\n" +
				"('Sahil','Deepak Patel','20105117052','cse','2nd'),\n" +
				"('Ritik','Kumar','20105117053','cse','2nd'),\n" +
				"('Anjali','Gupta','20105117054','cse','2nd'),\n" +
				"('Anisha','Kumari','20105117055','cse','2nd'),\n" +
				"('Aparna','Singh','20105117056','cse','2nd'),\n" +
				"('Aman','Prasar','21105117901','cse','2nd'),\n" +
				"('Varsha','Kumari','21105117902','cse','2nd'),\n" +
				"('Himanshu','Kumar','21105117903','cse','2nd'),\n" +
				"('Vinita','Kumari','21105117904','cse','2nd'),\n" +
				"('Kajal','Kumari','21105117905','cse','2nd'),\n" +
				"('Annu','Kumari','21105117906','cse','2nd'),\n" +
				"('Prakriti','Kumari','21105117902','cse','2nd')";
		String sq = "INSERT or replace INTO student_table(student_firstname,student_lastname,student_address,student_department,student_class) VALUES('Tej','Pratap Karan','19105117062','cse','1st'),\n" +
				"('Mayank','','21105117001','cse','1st'),\n" +
				"('Anmol','Kumar','21105117002','cse','1st'),\n" +
				"('Rayees','Alam','21105117003','cse','1st'),\n" +
				"('Sandhya','Patel','21105117004','cse','1st'),\n" +
				"('Shiwani','Kumari','21105117005','cse','1st'),\n" +
				"('Ajay','Kumar','21105117006','cse','1st'),\n" +
				"('Aditya','Anand','21105117007','cse','1st'),\n" +
				"('Prakash','Kumar','21105117008','cse','1st'),\n" +
				"('Harsh','Raj','21105117009','cse','1st'),\n" +
				"('Abhishek','Raaz','21105117010','cse','1st'),\n" +
				"('Md','Abdullah','21105117011','cse','1st'),\n" +
				"('Aman','Kumar Raj','21105117012','cse','1st'),\n" +
				"('Suraj','Kumar Sah','21105117013','cse','1st'),\n" +
				"('Alok','Kashyap','21105117014','cse','1st'),\n" +
				"('Abhishek','Kumar','21105117015','cse','1st'),\n" +
				"('Satish','Kumar Thakur','21105117016','cse','1st'),\n" +
				"('Md','Saddam','21105117017','cse','1st'),\n" +
				"('Badal','Kumar','21105117018','cse','1st'),\n" +
				"('Abhishek','Kumar','21105117019','cse','1st'),\n" +
				"('Ankit','Raj Sinha','21105117020','cse','1st'),\n" +
				"('Ram','Sagar Kumar','21105117021','cse','1st'),\n" +
				"('Aman','Kumar Singh','21105117022','cse','1st'),\n" +
				"('Rupesh','Kumar','21105117023','cse','1st'),\n" +
				"('Ritik','Raushan','21105117024','cse','1st'),\n" +
				"('Amit','Kumar','21105117025','cse','1st'),\n" +
				"('Anand','Raj','21105117026','cse','1st'),\n" +
				"('Yuvraj','Singh','21105117027','cse','1st'),\n" +
				"('Rohit','Shekhar','21105117028','cse','1st'),\n" +
				"('Nitish','Kumar','21105117029','cse','1st'),\n" +
				"('Shefali','Shreya','21105117030','cse','1st'),\n" +
				"('Manisha','Jaishwal','21105117031','cse','1st'),\n" +
				"('Sharwan','KUMAR Mahto','21105117032','cse','1st'),\n" +
				"('Varun','Kumar','21105117033','cse','1st'),\n" +
				"('Om','Prakash','21105117034','cse','1st'),\n" +
				"('Srishti','Shwadha','21105117035','cse','1st'),\n" +
				"('Bashistha','Nirala','21105117036','cse','1st'),\n" +
				"('Aditya','Anand Kashyap','21105117037','cse','1st'),\n" +
				"('Lucy','Kumari','21105117038','cse','1st'),\n" +
				"('Ashik','Raja','21105117039','cse','1st'),\n" +
				"('Rahul','Kumar','21105117040','cse','1st'),\n" +
				"('Asmit','Raj','21105117041','cse','1st'),\n" +
				"('Suraj','Kant','21105117042','cse','1st'),\n" +
				"('Supriya','Singh','21105117043','cse','1st'),\n" +
				"('Rahul','Kumar','21105117044','cse','1st'),\n" +
				"('Adarsh','Raj','21105117045','cse','1st'),\n" +
				"('Prince','Kumar','21105117046','cse','1st'),\n" +
				"('Vikash','Kumar','21105117047','cse','1st'),\n" +
				"('Ram','Kumar Paswan','21105117048','cse','1st'),\n" +
				"('Avijeet','Kumar Roy','21105117049','cse','1st'),\n" +
				"('Gaurav','Kumar','21105117050','cse','1st'),\n" +
				"('Mayank','','21105117051','cse','1st'),\n" +
				"('Aparna','Jyoti','21105117052','cse','1st'),\n" +
				"('Amit','Kumar Yadav','21105117053','cse','1st'),\n" +
				"('Ankit','Kumar Singh','21105117054','cse','1st'),\n" +
				"('Md','Asher','21105117055','cse','1st'),\n" +
				"('Pintu','Kumar','21105117056','cse','1st'),\n" +
				"('Fariya','Rafat','21105117057','cse','1st'),\n" +
				"('Shuruti','Raj','21105117058','cse','1st'),\n" +
				"('Babloo','Kumar','21105117059','cse','1st')";
		String ss = "INSERT or replace INTO student_table(student_firstname,student_lastname,student_address,student_department,student_class) VALUES('Vedant','Kumar','18105117022','cse','3rd'),('Vikash','Kumar Chaudhary','18105117030','cse','3rd'),('Ritika','','18105117030','cse','3rd'),('Rohit','kumar','18105117030','cse','3rd'),('Ankit','kumar','19105117001','cse','3rd'),('Shashi','Shekher Sharma','19105117002','cse','3rd'),('Sanjeev','kumar','19105117003','cse','3rd'),('Mukul','Raj','19105117004','cse','3rd'),('Suraj','Kumar','19105117005','cse','3rd'),('Vishal','kumar','19105117006','cse','3rd'),('Arbind','kumar','19105117007','cse','3rd'),('Nirman','Kumar','19105117008','cse','3rd'),('Chanchal','Kumar','19105117009','cse','3rd'),('Prince','Raj','19105117010','cse','3rd'),('Alok','Kumar','19105117011','cse','3rd'),('Chandan','Kumar Chaudhary','19105117012','cse','3rd'),('Satyam','Swaraj','19105117013','cse','3rd'),('Shashikant','','19105117014','cse','3rd'),('Vinita','Kumari','19105117015','cse','3rd'),('Priyanshu','Solon','19105117016','cse','3rd'),('Raushan','Kumar','19105117017','cse','3rd'),('Kshitu','Kumar','19105117018','cse','3rd'),('Piyush','Ravi','19105117019','cse','3rd'),('Aditya','Raj','19105117020','cse','3rd'),('Rahul','Raj','19105117021','cse','3rd'),('Divyank','Kumar Chaudhary','19105117022','cse','3rd'),('Ankita','Anu','19105117023','cse','3rd'),('Shubham','Kumar','19105117024','cse','3rd'),('Mukesh','Kumar','19105117025','cse','3rd'),('Adarsh','Yadav','19105117026','cse','3rd'),('Naveen','Kumar','19105117027','cse','3rd'),('Ayushi','Raj','19105117028','cse','3rd'),('Ankit','Raj','19105117029','cse','3rd'),('Rohit','Gupta','19105117030','cse','3rd'),('Aiman','Imam','19105117031','cse','3rd'),('Mayank','Kumar','19105117032','cse','3rd'),('MD kamre','Alam','19105117033','cse','3rd'),('Sintu','Ram','19105117034','cse','3rd'),('Ankur','Anand','19105117035','cse','3rd'),('MD Dilshad','Alam','19105117036','cse','3rd'),('MD Asif ','Raja','19105117037','cse','3rd'),('Adiya','Kumar','19105117038','cse','3rd'),('Sudheer','Kumar Yadav','19105117039','cse','3rd'),('Chandan','Kumar','19105117040','cse','3rd'),('Harsh','Raj','19105117041','cse','3rd'),('Anupriya','','19105117042','cse','3rd'),('Smriti','','19105117043','cse','3rd'),('Sachin','Kumar','19105117044','cse','3rd'),('Aradhya','','19105117045','cse','3rd'),('Saurav','Kumar Topo','19105117046','cse','3rd'),('Juhi','Mishra','19105117047','cse','3rd'),('Priyanshu','Kumari','19105117048','cse','3rd'),('Anupriya','','19105117049','cse','3rd'),('Shreya','Singh','19105117050','cse','3rd'),('Nisha','Kumari','19105117051','cse','3rd'),('Anurag','Kumar','19105117052','cse','3rd'),('Anil','Kumar','19105117053','cse','3rd'),('Shreya','Kumari','19105117054','cse','3rd'),('Ankit','Raj','19105117055','cse','3rd'),('Avinash','Garg','19105117056','cse','3rd'),('Adarsh','Kumar','19105117057','cse','3rd'),('Hrithik','Raushan','19105117058','cse','3rd'),('Prince','Sah','19105117059','cse','3rd'),('Shubham','Mehta','19105117060','cse','3rd'),('Shubham','Kumar','19105117061','cse','3rd'),('Tej','Pratap Karn','19105117062','cse','3rd'),('Chandni','Kumari','20105117901','cse','3rd'),('Kalpana','Kumari','20105117902','cse','3rd'),('Amit','Kumar','20105117904','cse','3rd'),('Ritik','Kumar','20105117905','cse','3rd'),('Mayank','Kumar','20105117906','cse','3rd'),('Nisha','Kumari','20105117907','cse','3rd'),('Raja ','Kumar','20105117908','cse','3rd')";
		db.execSQL(sql);
		db.execSQL(ss);
		db.execSQL(s);
		db.execSQL(sq);
		db.close();
	}


	public ArrayList<StudentBean> getAllStudent()
	{
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();

		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT * FROM student_table";
		Cursor cursor = db.rawQuery(query, null);

		if(cursor.moveToFirst()) 
		{
			do{
				StudentBean studentBean = new StudentBean();
				studentBean.setStudent_id(Integer.parseInt(cursor.getString(0)));
				studentBean.setStudent_firstname(cursor.getString(1));
				studentBean.setStudent_lastname(cursor.getString(2));
				studentBean.setStudent_mobilenumber(cursor.getString(3));
				studentBean.setStudent_address(cursor.getString(4));
				studentBean.setStudent_department(cursor.getString(5));
				studentBean.setStudent_class(cursor.getString(6));
				list.add(studentBean);
			}while(cursor.moveToNext());
		}
		return list;
	}

	public ArrayList<StudentBean> getAllStudentByBranchYear(String branch,String year)
	{
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();

		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT * FROM student_table where student_department='"+branch+"' and student_class='"+year+"'";
		Cursor cursor = db.rawQuery(query, null);

		if(cursor.moveToFirst()) 
		{
			do{
				StudentBean studentBean = new StudentBean();
				studentBean.setStudent_id(Integer.parseInt(cursor.getString(0)));
				studentBean.setStudent_firstname(cursor.getString(1));
				studentBean.setStudent_lastname(cursor.getString(2));
				studentBean.setStudent_mobilenumber(cursor.getString(3));
				studentBean.setStudent_address(cursor.getString(4));
				studentBean.setStudent_department(cursor.getString(5));
				studentBean.setStudent_class(cursor.getString(6));
				list.add(studentBean);
			}while(cursor.moveToNext());
		}
		return list;
	}

	public StudentBean getStudentById(int studentId)
	{
		StudentBean studentBean = new StudentBean();
		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT * FROM student_table where student_id="+studentId;
		Cursor cursor = db.rawQuery(query, null);

		if(cursor.moveToFirst()) 
		{
			do{
				
				studentBean.setStudent_id(Integer.parseInt(cursor.getString(0)));
				studentBean.setStudent_firstname(cursor.getString(1));
				studentBean.setStudent_lastname(cursor.getString(2));
				studentBean.setStudent_mobilenumber(cursor.getString(3));
				studentBean.setStudent_address(cursor.getString(4));
				studentBean.setStudent_department(cursor.getString(5));
				studentBean.setStudent_class(cursor.getString(6));
				
			}while(cursor.moveToNext());
		}
		return studentBean;
	}

	public void deleteStudent(int studentId) {
		SQLiteDatabase db = this.getWritableDatabase();

		String query = "DELETE FROM student_table WHERE student_id="+studentId ;

		Log.d("query", query);
		db.execSQL(query);
		db.close();
	}

	//attendance session Table crud
	public int addAttendanceSession(AttendanceSessionBean attendanceSessionBean) {
		SQLiteDatabase db = this.getWritableDatabase();

		String query = "INSERT INTO attendance_session_table (attendance_session_faculty_id,attendance_session_department,attendance_session_class,attendance_session_date,attendance_session_subject) values ('"+ 
				attendanceSessionBean.getAttendance_session_faculty_id()+"', '"+
				attendanceSessionBean.getAttendance_session_department()+"','"+
				attendanceSessionBean.getAttendance_session_class()+"', '"+
				attendanceSessionBean.getAttendance_session_date()+"', '"+
				attendanceSessionBean.getAttendance_session_subject()+"')";
		Log.d("query", query);
		db.execSQL(query);

		String query1= "select max(attendance_session_id) from attendance_session_table";
		Cursor cursor = db.rawQuery(query1, null);
		
		if(cursor.moveToFirst())
		{
			int sessionId = Integer.parseInt(cursor.getString(0));
			
			return sessionId;
		}
			
		
		db.close();
		return 0;
	}

	public ArrayList<AttendanceSessionBean> getAllAttendanceSession()
	{
		ArrayList<AttendanceSessionBean> list = new ArrayList<AttendanceSessionBean>();

		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT * FROM attendance_session_table";
		Cursor cursor = db.rawQuery(query, null);

		if(cursor.moveToFirst()) 
		{
			do{
				AttendanceSessionBean attendanceSessionBean = new AttendanceSessionBean();
				attendanceSessionBean.setAttendance_session_id(Integer.parseInt(cursor.getString(0)));
				attendanceSessionBean.setAttendance_session_faculty_id(Integer.parseInt(cursor.getString(1)));
				attendanceSessionBean.setAttendance_session_department(cursor.getString(2));
				attendanceSessionBean.setAttendance_session_class(cursor.getString(3));
				attendanceSessionBean.setAttendance_session_date(cursor.getString(4));
				attendanceSessionBean.setAttendance_session_subject(cursor.getString(5));
				list.add(attendanceSessionBean);
			}while(cursor.moveToNext());
		}
		return list;
	}

	public void deleteAttendanceSession(int attendanceSessionId) {
		SQLiteDatabase db = this.getWritableDatabase();

		String query = "DELETE FROM attendance_session_table WHERE attendance_session_id="+attendanceSessionId ;

		Log.d("query", query);
		db.execSQL(query);
		db.close();
	}
	//attendance crud
	public void addNewAttendance(AttendanceBean attendanceBean) {
		SQLiteDatabase db = this.getWritableDatabase();

		String query = "INSERT INTO attendance_table values ("+ 
				attendanceBean.getAttendance_session_id()+", "+
				attendanceBean.getAttendance_student_id()+", '"+
				attendanceBean.getAttendance_status()+"')";
		Log.d("query", query);
		db.execSQL(query);
		db.close();
	}
	
	
	public ArrayList<AttendanceBean> getAttendanceBySessionID(AttendanceSessionBean attendanceSessionBean)
	{
		int attendanceSessionId=0;
		ArrayList<AttendanceBean> list = new ArrayList<AttendanceBean>();

		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT * FROM attendance_session_table where attendance_session_faculty_id="+attendanceSessionBean.getAttendance_session_faculty_id()+""
				+" AND attendance_session_department='"+attendanceSessionBean.getAttendance_session_department()+"' AND attendance_session_class='"+attendanceSessionBean.getAttendance_session_class()+"'" +
						" AND attendance_session_date='"+attendanceSessionBean.getAttendance_session_date()+"' AND attendance_session_subject='"+attendanceSessionBean.getAttendance_session_subject()+"'";
		Cursor cursor = db.rawQuery(query, null);

		if(cursor.moveToFirst()) 
		{
			do{
				attendanceSessionId=(Integer.parseInt(cursor.getString(0)));
			}while(cursor.moveToNext());
		}
		
		String query1="SELECT * FROM attendance_table where attendance_session_id=" + attendanceSessionId+" order by attendance_student_id";
		Cursor cursor1 = db.rawQuery(query1, null);
		if(cursor1.moveToFirst()) 
		{
			do{
				AttendanceBean attendanceBean = new AttendanceBean();
				attendanceBean.setAttendance_session_id(Integer.parseInt(cursor1.getString(0)));
				attendanceBean.setAttendance_student_id(Integer.parseInt(cursor1.getString(1)));
				attendanceBean.setAttendance_status(cursor1.getString(2));
				list.add(attendanceBean);

			}while(cursor1.moveToNext());
		}
		return list;
	}
	
	public ArrayList<AttendanceBean> getTotalAttendanceBySessionID(AttendanceSessionBean attendanceSessionBean)
	{
		int attendanceSessionId=0;
		ArrayList<AttendanceBean> list = new ArrayList<AttendanceBean>();

		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT * FROM attendance_session_table where attendance_session_faculty_id="+attendanceSessionBean.getAttendance_session_faculty_id()+""
				+" AND attendance_session_department='"+attendanceSessionBean.getAttendance_session_department()+"' AND attendance_session_class='"+attendanceSessionBean.getAttendance_session_class()+"'" +
						" AND attendance_session_subject='"+attendanceSessionBean.getAttendance_session_subject()+"'";
		Cursor cursor = db.rawQuery(query, null);

		if(cursor.moveToFirst()) 
		{
			do{
				attendanceSessionId=(Integer.parseInt(cursor.getString(0)));
				
				String query1="SELECT * FROM attendance_table where attendance_session_id=" + attendanceSessionId+" order by attendance_student_id";
				Cursor cursor1 = db.rawQuery(query1, null);
				if(cursor1.moveToFirst()) 
				{
					do{
						AttendanceBean attendanceBean = new AttendanceBean();
						attendanceBean.setAttendance_session_id(Integer.parseInt(cursor1.getString(0)));
						attendanceBean.setAttendance_student_id(Integer.parseInt(cursor1.getString(1)));
						attendanceBean.setAttendance_status(cursor1.getString(2));
						list.add(attendanceBean);

					}while(cursor1.moveToNext());
				}
				
				AttendanceBean attendanceBean = new AttendanceBean();
				attendanceBean.setAttendance_session_id(0);
				attendanceBean.setAttendance_status("Date : " + cursor.getString(4));
				list.add(attendanceBean);
				
			}while(cursor.moveToNext());
		}
		
		
		return list;
	}
	
	public ArrayList<AttendanceBean> getAllAttendanceByStudent()
	{
		ArrayList<AttendanceBean> list = new ArrayList<AttendanceBean>();

		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT attendance_student_id,count(*) FROM attendance_table where attendance_status='P' group by attendance_student_id";
		
		Log.d("query", query);
		
		Cursor cursor = db.rawQuery(query, null);
		
		

		if(cursor.moveToFirst()) 
		{
			do{
				Log.d("studentId","studentId:"+cursor.getString(0)+", Count:"+cursor.getString(1));
				AttendanceBean attendanceBean = new AttendanceBean();
				attendanceBean.setAttendance_student_id(Integer.parseInt(cursor.getString(0)));
				attendanceBean.setAttendance_session_id(Integer.parseInt(cursor.getString(1)));
				list.add(attendanceBean);

			}while(cursor.moveToNext());
		}
		return list;
	}
}