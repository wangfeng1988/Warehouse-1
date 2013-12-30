function getCookie(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=");
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1;
			c_end = document.cookie.indexOf(";", c_start);
			if (c_end == -1)
				c_end = document.cookie.length;
			return unescape(document.cookie.substring(c_start, c_end));
		}
	}
	return "";
}

function setCookie(name, password, expiredays) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + expiredays);
	document.cookie = "username=" + escape(name) + ";password="+ escape(password)+
			((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
}

/*这里只检查了是否有用户名，并未检查用户名和密码是否匹配*/
function checkCookie() {
	username = getCookie('username');
	if (username != null && username != "") {
		window.location.href = "MainWarehousingEntry.jsp";
	}
}