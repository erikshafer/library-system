package com.userfront.service.UserServiceImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userfront.dao.CheckoutDao;
import com.userfront.domain.Book;
import com.userfront.domain.Checkout;
import com.userfront.domain.User;
import com.userfront.service.CheckoutService;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private CheckoutDao checkoutDao;

	public Checkout createCheckout(Checkout checkout) {
		return checkoutDao.save(checkout);
	}

	public List<Checkout> findAll() {
		return checkoutDao.findAll();
	}

	public Checkout findCheckout(Long id) {
		return checkoutDao.findOne(id);
	}

	public void confirmCheckout(Long id) {
		Checkout checkout = findCheckout(id);
		checkout.setCheckedOut(true);
		checkoutDao.save(checkout);
	}
	
	public List<Checkout> findUserPastDue(User user) {
//		List<Checkout> pastDue = new ArrayList<>();
//		LocalDate localDate = LocalDate.now();
//		Date today = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//		
//		for (Checkout currCheckout : findByUser(user)) {
//			if (currCheckout.getDateDue().before(today)); {
//				pastDue.add(currCheckout);
//			}
//		}
		return null;
	}

	@Override
	public List<Checkout> findByUser(User user) {
		return checkoutDao.findByUser(user);
	}

	@Override
	public List<Checkout> findByBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * @author TagnikHome
	 * If true, that means the book is out on loan (borrowed).
	 */
	public List<Checkout> findByCheckedOut(Boolean out) {
		return checkoutDao.findByCheckedOut(out);	// true (0) = it's out
	}

	@Override
	public List<Checkout> findByDateDueBeforeAndUser(Date date, User user) {
		return checkoutDao.findByDateDueBeforeAndUser(date, user);
	}

	@Override
	public void save(Checkout checkout) {
		checkoutDao.save(checkout);
		
	}

}
