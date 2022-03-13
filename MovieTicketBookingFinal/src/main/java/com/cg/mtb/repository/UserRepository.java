package com.cg.mtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mtb.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	/*public User findByUserName(String username) throws UserNotFoundException {
		TypedQuery<User> qry = eManager.createQuery("select u from User u where u.username like :name", User.class);
		qry.setParameter("name", username);
		List<User> user = qry.getResultList();
		if (user.size() == 0)
			throw new UserNotFoundException("User Not Available !!");
		return user.get(0);
	}
*/
}