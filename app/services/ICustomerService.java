package services;

import com.google.inject.ImplementedBy;

/**
 * Created by jjcosare on 6/7/15.
 */
@ImplementedBy(CustomerService.class)
public interface ICustomerService {

    String sortByDueDate(String json);
}
