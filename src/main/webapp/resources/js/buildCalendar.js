let today = new Date();
today = new Date(today.getFullYear(), today.getMonth(), today.getDate());
var date = new Date();
let this_year = today.getFullYear();
let this_month = today.getMonth() + 1;

function last_month_click() {
	today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
	const year = document.getElementById('year');
	const month = document.getElementById('month');
	year.innerText = today.getFullYear() + "년";
	month.innerText = today.getMonth() + 1 + "월";

	buildCalendar();
}

function next_month_click() {
	today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
	const year = document.getElementById('year');
	const month = document.getElementById('month');
	year.innerText = today.getFullYear() + "년";
	month.innerText = today.getMonth() + 1 + "월";

	buildCalendar();
}

function buildCalendar() {
	var doMonth = new Date(today.getFullYear(), today.getMonth(), 1);
	var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
	var tbCalendar = document.getElementById("calendar");

	while (tbCalendar.rows.length > 0) {
		tbCalendar.deleteRow(tbCalendar.rows.length - 1);
	}
	var row = null;
	row = tbCalendar.insertRow();
	var cnt = 0;
	for (i = 0; i < doMonth.getDay(); i++) {
		cell = row.insertCell();
		cnt = cnt + 1;
	}

	for (i = 1; i <= lastDate.getDate(); i++) {
		cell = row.insertCell();
		cell.innerHTML = i;
		cnt = cnt + 1;
		if (cnt % 7 == 1) {
			cell.innerHTML = "<font color=#F79DC2>" + i;
		}
		if (cnt % 7 == 0) {
			cell.innerHTML = "<font color=skyblue>" + i
			row = calendar.insertRow();
		}
		if (today.getFullYear() == date.getFullYear()
			&& today.getMonth() == date.getMonth()
			&& i == date.getDate()) {
			cell.bgColor = "#FAF58C";
		}
	}
}