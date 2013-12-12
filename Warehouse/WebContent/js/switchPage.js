function switchPageOfEntry(tag)
{
	document.getElementById("navactive").setAttribute("id", "");
	document.getElementById("navform").getElementsByTagName("li")[tag].setAttribute("id","navactive");
	
	document.getElementById("select").setAttribute("class", "tabhidden");
	document.getElementById("add").setAttribute("class", "tabhidden");
	document.getElementById("collect").setAttribute("class", "tabhidden");
	
	switch(tag)
	{
	case "0":
		document.getElementById("select").setAttribute("class", "tabactive");
		break;
	case "1":
		document.getElementById("add").setAttribute("class", "tabactive");
		break;
	case "2":
		document.getElementById("collect").setAttribute("class", "tabactive");
		break;
	default:
		break;
	}

}