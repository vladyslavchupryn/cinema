function buildPages(firstPage, count, countOnPage, start) {
	var pages = new Array();
	pages[0] = {
		start: 0,
		end  : firstPage
	}
	var index = 1;
	for (var current = firstPage; current < count; current += countOnPage) {
		var end = current + countOnPage;
		if (end > count) {
			end = count;
		}
		pages[index] = {
			start: current,
			end  : end
		}

		index++;
	}
	return pages;
}

function buildRange(active, pages) {
	var PAGE_COUNT = 5;
	var start = active - 2;
	var end = active + 2;
	if (start < 0) {
		end += (-start);
		start = 0;
	}
	if (end > pages.length - 1) {
		var diff = end - (pages.length - 1);
		var end = (pages.length - 1);

		start -= diff;
		if (start < 0) {
			start = 0;
		}
	}
	return {start: start, end: end};
}

function buildPagination(range, active, url, pages) {
	for (var index = range.start; index <= range.end; index++) {
		var href = makePageUrl(url, pages[index].start, pages[index].end);

		var element = '';
		if (index == active) {
			element += '<li class="active">';
		} else {
			element += '<li>';
		}

		if(index == active - 1) {
			$('.pagination-prev a').attr('href',href);
		}

		if(index == active + 1) {
			$('.pagination-next a').attr('href',href);
		}

		element += '<a href="'+href+'">';
		element += index + 1;
		element += '</a>';
		element += '</li>';

		$(element).insertBefore('.pagination-next');
	}
}

function makePageUrl(url, start, end) {
	return makeUrl(url, "pageStart="+start+"&pageEnd="+end);
}

function makeUrl(url, param) {
	if(url.indexOf("?") === -1) {
		return url + "?" + param;
	} else {
		return url + "&" + param;
	}
}

function initPaginator(start, end, count, url) {
	var countOnPage = end - start;
	var active = start / countOnPage;
	var firstPage = start % countOnPage;
	if (firstPage > 0) {
		active++;
	} else {
		firstPage = countOnPage;
	}

	var pages = buildPages(firstPage, count, countOnPage, start);

	if (active == 0) {
		$('.pagination-prev').addClass('disabled');
	}
	if (active == pages.length - 1) {
		$('.pagination-next').addClass('disabled');
	}

	var range = buildRange(active, pages);

	buildPagination(range, active, url, pages);
}
