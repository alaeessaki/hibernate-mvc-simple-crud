package models;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import Beans.HibernateUtil;
import Beans.Person;

public class PersonDAO {
	
	
	public List<Person> getAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "FROM Person";
		Query query = session.createQuery(hql);
		
		List<Person> personnes = query.list();
		
		session.close();
		return personnes;
	}
	
	public Person getPerson(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Person person = (Person) session.get(Person.class, id);
		return person;
	}
	
	public void addPerson(Person person) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.save(person);
		Transaction ts = session.beginTransaction();
		ts.commit();
		session.close();
	}
	
	public void updatePerson(Person person) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.saveOrUpdate(person);
		Transaction ts = session.beginTransaction();
		ts.commit();
		session.close();
	}
	
	public void deletePerson(Person person) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.delete(person);
		
		Transaction ts = session.beginTransaction();
		ts.commit();
		session.close();
	}	
}
