package dataModels;

public class Customer {
	String _email;
	String _username;
	String _password;
	String _firstName;
	String _lastName;
	String _address;
	String _cardNumber;
	public Customer(String email, String username, String password, String firstName, String lastName,String address, String cardNumber) {
		_email = email;
		_address = address;
		_cardNumber = cardNumber;
		_password = password;
		_username = username;
		_firstName = firstName;
		_lastName = lastName;
	}
	public String get_email() {
		return _email;
	}
	public void set_email(String _email) {
		this._email = _email;
	}
	public String get_username() {
		return _username;
	}
	public void set_username(String _username) {
		this._username = _username;
	}
	public String get_password() {
		return _password;
	}
	public void set_password(String _password) {
		this._password = _password;
	}
	public String get_firstName() {
		return _firstName;
	}
	public void set_firstName(String _firstName) {
		this._firstName = _firstName;
	}
	public String get_lastName() {
		return _lastName;
	}
	public void set_lastName(String _lastName) {
		this._lastName = _lastName;
	}
	public String get_address() {
		return _address;
	}
	public void set_address(String _address) {
		this._address = _address;
	}
	public String get_cardNumber() {
		return _cardNumber;
	}
	public void set_cardNumber(String _cardNumber) {
		this._cardNumber = _cardNumber;
	}
	
}
