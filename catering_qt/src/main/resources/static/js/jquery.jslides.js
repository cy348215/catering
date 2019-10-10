/**
 * jQuery jslides 1.1.0
 *
 * http://www.cactussoft.cn
 *
 * Copyright (c) 2009 - 2013 Jerry
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 */
$(function() {
	var numpic = $('#slides li').size() - 1;
	var nownow = 0;
	var inout = 0;
	var TT = 0;
	var SPEED = 5000;


	$('#slides li').eq(0).siblings('li').css({'display': 'none'});


	var ulstart = '<ul id="pagination">',
		ulcontent = '',
		ulend = '</ul>';
	ADDLI();
	var pagination = $('#pagination li');
	var paginationwidth = $('#pagination').width();
	//$('#pagination').css('margin-left',(470-paginationwidth))

	pagination.eq(0).addClass('current')

	function ADDLI() {
		//var lilicount = numpic + 1;
		for (var i = 0; i <= numpic; i++) {
			ulcontent += '<li>' + '<a href="javascript:;">' + (i + 1) + '</a>' + '</li>';
		}

		$('#slides').after(ulstart + ulcontent + ulend);
	}
})