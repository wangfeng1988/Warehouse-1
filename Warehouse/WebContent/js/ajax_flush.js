function showMaterial()
{
	alert("hello");
	var xmlhttp=new XMLHttpRequest();

	alert(xmlhttp.responseText);
	
	xmlhttp.open("POST","http://localhost:8080/Warehouse/test.action", true);
	xmlhttp.send();
}

function showEntry(str)
{
	var xmlhttp;
	if (str == "") 
	{
		document.getElementById("txtHint").innerHTML = "";
		return;
	}
	if (window.XMLHttpRequest)
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} 
	else 
	{
		// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() 
	{
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
		{
			document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
		}
	};
	
	xmlhttp.open("GET", "getcustomer.asp?q=" + str, true);
	xmlhttp.send();
}