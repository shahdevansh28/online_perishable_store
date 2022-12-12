package com.online_perishable_store.ops;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.online_perishable_store.cart.Cart;
import com.online_perishable_store.cart.CartRepository;
import com.online_perishable_store.order.Order;
import com.online_perishable_store.order.OrderRepository;
import com.online_perishable_store.orderitem.OrderItem;
import com.online_perishable_store.orderitem.OrderItemRepository;
import com.online_perishable_store.product.Product;
import com.online_perishable_store.product.ProductRepository;
import com.online_perishable_store.user.TryBean;
import com.online_perishable_store.user.User;
import com.online_perishable_store.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OpsController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private CartRepository cartRepository;
	@RequestMapping("/")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/login")
	public String loginpage(){
		return "login";
	}
	@RequestMapping("/signin")
	public String signin()
	{
		return "signin";
	}
	@RequestMapping(value="/validateLogin",method=RequestMethod.POST)
	public String validateLogin(@ModelAttribute User user,Model model,HttpServletRequest request){
		User foundUser=userRepository.findByEmailAddress(user.email);
		if(foundUser==null){
			model.addAttribute("confirmation_msg","please enter valid data");
			model.addAttribute("go_back_url","login");
			System.out.println("unmatch");
			return "customerConfirmationPage";
		}
		System.out.println("foudnUser : "+foundUser);
		System.out.println("in validate login now");
		System.out.println(foundUser.password+ " "+ user.password + " "+foundUser.userType + "  "+ user.userType);
		
		request.getSession().setMaxInactiveInterval(3600);
		request.getSession().setAttribute("user", foundUser);
		if (foundUser.password.equals(user.password) && foundUser.userType.equals(user.userType)){
			System.out.println("match");
			model.addAttribute("user",user);
			if(foundUser.userType.equals("admin")) return "redirect:/adminHome?userId="+foundUser.userid;
			else return "redirect:/customerHome";
		}
		model.addAttribute("confirmation_msg","please enter valid data");
		model.addAttribute("go_back_url","login");
		System.out.println("unmatch");
		return "customerConfirmationPage";
	}
	@RequestMapping("/addProduct")
	public String addProduct(){
		return "addProductPage";
	}
	@RequestMapping("/adminHome")
	public String adminHome(Model model,HttpServletRequest request){
		ArrayList<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(products::add);
		// System.out.println("products all : "+products);
		request.getSession().setMaxInactiveInterval(3600);
		model.addAttribute("products", products);
		model.addAttribute("user",request.getSession().getAttribute("user"));
		return "adminHomePage";
	}
	@RequestMapping("/customerHome")
	public String customerHome(Model model,HttpServletRequest request){
		ArrayList<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(products::add);
		// System.out.println("products all : "+products);
		request.getSession().setMaxInactiveInterval(3600);
		model.addAttribute("user", request.getSession().getAttribute("user"));
		model.addAttribute("products", products);
		return "customerHomePage";
	}
	@RequestMapping(value="/validateSignin",method=RequestMethod.POST)
	public String validateSignin(@ModelAttribute User user,Model model,HttpServletRequest request){
		userRepository.save(user);
		model.addAttribute("user",user);
		// session.addAttribute("user",user);
		request.getSession().setMaxInactiveInterval(3600);
		request.getSession().setAttribute("user", user);

		System.out.println("model : "+model);
		return "redirect:/customerHome";
	}
	@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product,Model model){
		// System.out.println("product : "+product);
		productRepository.save(product);
		System.out.println("product id : "+product.productid);
		return "redirect:/./displayProductAdmin?productid="+product.productid;
	}
	@RequestMapping(value="/seeConcreteProduct",method=RequestMethod.POST)
	public String seeConcreteProduct(@ModelAttribute Product product,Model model){
		model.addAttribute("product",product);
		return "displayProductPage";
	}
	@RequestMapping(value="/seeConcreteProductAdmin",method=RequestMethod.POST)
	public String seeConcreteProductAdmin(@ModelAttribute Product product,Model model){
		model.addAttribute("product",product);
		return "displayProductAdminPage";
	}
	@RequestMapping(value="/displayProductAdmin", method = RequestMethod.GET)
	public String displayProductAdmin(@RequestParam("productid") Long productid,Model model) {
		System.out.println("in display product , product id : "+productid);
		
		Optional<Product> prod=productRepository.findById(productid);
		if(prod.isPresent()) {
			Product dispProduct=prod.get();
			System.out.println("recieved prod : "+dispProduct);
			model.addAttribute("product", dispProduct);
			return "displayProductAdminPage"	;
		}
		model.addAttribute("confirmation_msg","please enter valid data");
		model.addAttribute("go_back_url","login");
		return "customerConfirmationPage";
	}
	@RequestMapping(value="/displayProduct", method = RequestMethod.GET)
	public String displayProduct(@RequestParam("productid") Long productid,Model model) {
		System.out.println("in display product , product id : "+productid);
		
		Optional<Product> prod=productRepository.findById(productid);
		if(prod.isPresent()) {
			Product dispProduct=prod.get();
			System.out.println("recieved prod : "+dispProduct);
			model.addAttribute("product", dispProduct);
			return "displayProductPage"	;
		}
		model.addAttribute("confirmation_msg","please enter valid data");
		model.addAttribute("go_back_url","login");
		return "customerConfirmationPage";
	}
	@RequestMapping(value="/seeProduct", method = RequestMethod.GET)
	public String seeProduct(@RequestParam("productid") Long productid,Model model,HttpServletRequest request) {
		System.out.println("in display product , product id : "+productid);
		
		Optional<Product> prod=productRepository.findById(productid);
		if(prod.isPresent()) {
			Product dispProduct=prod.get();
			System.out.println("recieved prod : "+dispProduct);
			model.addAttribute("product", dispProduct);
			request.getSession().setMaxInactiveInterval(3600);
			model.addAttribute("user",request.getSession().getAttribute("user"));
			return "seeProductPage"	;
		}
		return "errorPage";
	}
	
	@RequestMapping(value="/displayAllProducts")
	public String displayAllProducts(Model model){
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(products::add);
		// System.out.println("products all : "+products);
		model.addAttribute("products", products);
		return "displayAllProductsPage";
	}	
	@RequestMapping(value="/listAllUsers")
	public String listAllUsers(Model model){
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		System.out.println("users all : "+users);
		model.addAttribute("users", users);
		return "listAllUsersPage";
	}
	@RequestMapping(value="/addToCart",method=RequestMethod.GET)
	public String addToCart(@RequestParam("productId") Long productId,@RequestParam("userId") Long userId,@RequestParam("itemQuantity") Long itemQuantity,Model model,HttpServletRequest request){
		request.getSession().setMaxInactiveInterval(3600);
		OrderItem orderitem=new OrderItem();
		orderitem.setProductId(productId);
		orderitem.setItemQuantity(itemQuantity);
		System.out.println("orderitem in addToCart : "+orderitem);
		orderItemRepository.save(orderitem);
		System.out.println("after saving order item in addToCart : "+orderitem);
		Cart crt=new Cart();
		crt.setOrderItemId(orderitem.getOrderitemid());
		crt.setUserId(userId);
		System.out.println("crt in addToCart : "+crt);
		cartRepository.save(crt);
		Optional<Product> prod=productRepository.findById(productId);
		if(prod.isPresent()){
			Product updatedProduct=prod.get();
			updatedProduct.setProductQuantity(updatedProduct.getProductQuantity()-itemQuantity);
			System.out.println("updatedProduct in addToCart : "+updatedProduct);
			productRepository.save(updatedProduct);
			System.out.println("updatedProduct after updating product in addToCart :"+updatedProduct);
		}
		System.out.println("crt after saving order item in addToCart : "+crt);
		model.addAttribute("confirmation_msg","Product added to cart successfully");
		model.addAttribute("go_back_url","customerHome");
		return "customerConfirmationPage";
	}
	@RequestMapping(value="/seeMyCart")
	public String seeMyCart(@RequestParam("userId") Long userId ,Model model){
		System.out.println("userId is : "+userId);
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		List<Long> orderItemIds = cartRepository.findAllByUserId(userId);
		System.out.println("orderItemIds : "+orderItemIds);
		orderItemRepository.findAllById(orderItemIds).forEach(orderItems::add);
		System.out.println("orderItems after fetching in seeMyCart: "+orderItems);
		List<Product> products=new ArrayList<Product>();
		Long totalAmount=new Long((long)0);
		for(OrderItem orderItem : orderItems){
			
			Product prod=productRepository.findById(orderItem.getProductId()).get();
			prod.setProductQuantity(orderItem.getItemQuantity());
			products.add(prod);
			totalAmount+=orderItem.getItemQuantity()*prod.getProductPrice();
		}
		System.out.println("all products in cart : "+products);
		System.out.println("totalAmount : "+totalAmount);
		model.addAttribute("orderItems",orderItems);
		model.addAttribute("products",products);
		model.addAttribute("totalAmount",totalAmount);
		return "seeMyCartPage";
	}
	@RequestMapping(value="/placeOrder",method=RequestMethod.GET)
	public String placeOrder(@RequestParam("userId") Long userId,@RequestParam("totalAmount") Long totalAmount,Model model){
		System.out.println("userId is : "+userId);
		Order order=new Order();
		order.setTotalAmount(totalAmount);
		order.setOrderDate(new Date());
		order.setUserId(userId);
		System.out.println("order in placeOrder : "+order);
		orderRepository.save(order);
		System.out.println("order after save in placeOrder : "+order);
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		List<Cart> crt = cartRepository.findAllCartByUserId(userId);
		System.out.println("cart : "+crt);
		for(Cart cartItem:crt){
			orderItems.add(orderItemRepository.findById(cartItem.getOrderItemId()).get());
			cartRepository.delete(cartItem);
		}
		for(OrderItem orderItem : orderItems){
			orderItem.setOrderId(order.getOrderid());
			orderItemRepository.save(orderItem);
		}
		// cartRepository.deleteAllByUserId(userId);
		System.out.println("orderItems after updating in seeMyCart: "+orderItems);

		model.addAttribute("confirmation_msg","Your order has been placed successfully");
		model.addAttribute("go_back_url","customerHome");
		return "customerConfirmationPage";
	}
	@RequestMapping(value="/seeMyOrders")
	public String seeMyOrders(@RequestParam("userId") Long userId,Model model,HttpServletRequest request){
		List<Order> orders=orderRepository.findAllOrderByUserId(userId);
		System.out.println("orders : "+orders);
		model.addAttribute("user",request.getSession().getAttribute("user"));
		model.addAttribute("orders",orders);
		return "listAllOrders";
	}

	@RequestMapping("viewOrder")
	public String viewOrder(@RequestParam("orderId") Long orderId,Model model,HttpServletRequest request){
		List<Long> productIds=orderItemRepository.findAllOrderItemsById(orderId);
		System.out.println("productIds : "+productIds);
		List<Product> products=new ArrayList<Product>();
		Order order=orderRepository.findById(orderId).get();
		System.out.println("order : "+order);
		for(Long productId : productIds){
			products.add(productRepository.findById(productId).get());
		}

		System.out.println("Products : "+products);
		model.addAttribute("order",order);
		model.addAttribute("products",products);
		model.addAttribute("user",request.getSession().getAttribute("user"));
		return "viewOrderPage";
	}
}
