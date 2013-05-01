/*!
 * Bootstrap Context Menu
 * Version: 2.0
 * A small variation of the dropdown plugin by @sydcanem
 * https://github.com/sydcanem/bootstrap-contextmenu
 *
 * Twitter Bootstrap (http://twitter.github.com/bootstrap).
 */

/* =========================================================
 * bootstrap-dropdown.js
 * http://twitter.github.com/bootstrap/
 * =========================================================
 * Copyright 2012 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================= */

!(function ($) {

	"use strict"; // jshint ;_;

	/* CONTEXTMENU CLASS DEFINITION
	 * ============================ */

	var dataToggleSelector = '[data-toggle=context]';
	var ContextMenuFunction = function (element) {
		var $element = $(element);
		$element.on('contextmenu.context.data-api', this.toggle);

		var $target = $($element.attr('data-target'));

		$('html').on('click.context.data-api', function (e) {
			if (!e.ctrlKey) {
				$target.removeClass('open');
			}
		});
	};

	ContextMenuFunction.prototype = {
		/*
			эта строка добавлена, так как мы полностью переоперделяем значение
			prototype
		 */
		constructor: ContextMenuFunction,
		toggle: function (e) {
			var $this = $(this);

			if ($this.is('.disabled, :disabled')) {
				return;
			}

			var event = $.Event('context');
			$this.trigger(event);

			var $menu = getMenu($this);
			$menu.removeClass('open');

			var position = getPosition(e, $menu);
			$menu.attr('style', '')
				.css(position)
				.toggleClass('open');

			return false;
		}
	}

	function getMenu($this) {
		var selector = $this.attr('data-target');

		if (!selector) {
			selector = $this.attr('href')
			selector = selector && selector.replace(/.*(?=#[^\s]*$)/, '') //strip for ie7
		}

		var $menu = $(selector);

		return $menu;
	}

	function calcY(e, $menu) {
		var mouseY = e.clientY;
		var menuHeight = $menu.find('.dropdown-menu').outerHeight();
		var boundsY = $(window).height();

		if (mouseY + menuHeight > boundsY) {
			return mouseY - menuHeight;
		} else {
			return mouseY;
		}
	}

	function calcX(e, $menu) {
		var mouseX = e.clientX;
		var boundsX = $(window).width();
		var menuWidth = $menu.find('.dropdown-menu').outerWidth();

		if (mouseX + menuWidth > boundsX) {
			return mouseX - menuWidth;
		} else {
			return mouseX;
		}
	}

	function getPosition(e, $menu) {
		return {
			"position": "fixed",
			"top" : calcY(e, $menu),
			"left" : calcX(e, $menu)
		};
	}

	function clearMenus(e) {
		if (!e.ctrlKey) {
//			$(dataToggleSelector).each(function () {
//				var menu = getMenu($(this));
//				menu.removeClass('open');
//			});
		}
	}

	/* CONTEXT MENU PLUGIN DEFINITION
	 * ========================== */

	$.fn.contextmenu = function (option) {
		return this.each(function () {
			var $this = $(this);

			var data = $this.data('context');

			if (!data) {
				data = new ContextMenuFunction(this);
				$this.data('context', data);
			}

			if (typeof option == 'string') {
				/**
				 * вызов функции data[option] в контексте объекта $this
				 */
				data[option].call($this);
			} else {
				data.toggle.call($this, option);
			}
		});
	}

	/*
		http://stackoverflow.com/questions/10525600/what-is-the-purpose-of-fn-foo-constructor-foo-in-twitter-bootstrap-js

		по сути ни на что не влияет (только доступ к функции конструктору)
	 */
	$.fn.contextmenu.Constructor = ContextMenuFunction;

	/* APPLY TO STANDARD CONTEXT MENU ELEMENTS
	 * =================================== */

	$(function () {
		/*
			объявляет перехватчики стандартных

			пространства имен влияют только на наглядность и на совокупное
			управление событиями привязанными к пространствам
		 */
		$('html').on('click.context.data-api', clearMenus);
		$('body').on('contextmenu.context.data-api', dataToggleSelector, ContextMenuFunction.prototype.toggle);
	});
}(window.jQuery));
