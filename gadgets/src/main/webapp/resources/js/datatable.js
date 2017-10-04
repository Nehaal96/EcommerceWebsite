
$(document).ready( function () {
	 var table = $('#categoryTable').DataTable({
			"sAjaxSource": "categories",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "c_id"},
		      { "mData": "c_name" }/*,
				  { "mData": "product" }*/
				 
			]
	 });
	 var table1 = $('#supplierTable').DataTable({
			"sAjaxSource": "suppliers",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "s_id"},
		      { "mData": "s_name" }/*,
				  { "mData": "product" }*/
				 
			]
	 });
	 
	/* var table1 = $('#productTable').DataTable({
			"sAjaxSource": "products",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "p_id"},
		      { "mData": "p_name" },
				  { "mData": "product" }
				 
			]
	 });*/
});