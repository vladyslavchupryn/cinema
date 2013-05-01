/*SPIKE
	Тут неплохо было бы использовать какой-нибудь готовый фреймворк для подобных
	проверок. Также, стоило бы разбить функционвальность на модули, во избежании
	конфликтов имен.
	Однако, пока скрипт в таком виде в котором он есть
 */

function assertNull(object, variable) {
	"use strict";

	if (!object[variable]) {
		throw variable + " in " + object + "cannot be " + object.variable;
	}
}

function DatasetTree(option) {
	assertNull(option, "treeSelector");
	assertNull(option, "contextDivSelector");
	assertNull(option, "currentId");
	assertNull(option, "fromContainerSelector");


	this.treeElement = $(option.treeSelector);
	this.contextDivElement = $(option.contextDivSelector);
	this.fromContainerElement = $(option.fromContainerSelector);
	this.currentId = option.currentId;

	this.initTree();
}

DatasetTree.prototype = {
	constructor    : DatasetTree,
	bindContextMenu: function () {
		var that = this;
		this.treeElement.bind(
			'tree.contextmenu',
			function (event) {
				var node = event.node;

				that.contextDivElement.contextmenu(event.click_event);
				that.currentNodeId = node.id;
			}
		);
	},

	initTree: function () {
		this.treeElement.tree({
			dragAndDrop: true
		});

		this.bindContextMenu();
	},

//	current-dataset
	enableAjax : function() {
		var that = this;
		this.treeElement.bind('tree.select', function (event) {
			var node = event.node;

			net.fragment("clientDataset/index/"+node.id,"form").
				success(function (response) {
					that.fromContainerElement.html(response);
					ui.notify('Load successful');
				}).
				error(function (x, error) {
					ui.notify("Loading form: " + error, {type:'error'});
				});
		});
	},

	peekChildCreate: function (selector) {
		var that = this;
		$(selector).click(function () {
			assertNull(that, "currentNodeId");

			var parentId = that.currentNodeId;
			net.fragment("clientDataset/new/"+parentId,"form").
				success(function (response) {
					that.fromContainerElement.html(response);
					ui.notify('Form prepared');
				}).
				error(function (x, error) {
					ui.notify('Form preparing: ' + error, {type:'error'});
				});

			return false;
		});
	}

};

