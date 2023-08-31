$(function() {
	var today = moment().format('YYYY/MM/DD');
	var filterButtonIndex = -1;
	var filterCheckbox = [];
	var search_addr = null;
	var search_date = null;
	var search_person = null;

	var itemsToShow = 20;
	var $accommodationItems = $(".accommodation_item");

	$accommodationItems.slice(itemsToShow).addClass("hidden");

	$("#loadMoreButton").click(function() {
		var $hiddenItems = $(".accommodation_item.hidden");

		$hiddenItems.slice(0, itemsToShow).removeClass("hidden");

		if ($hiddenItems.length <= itemsToShow) {
			$("#loadMoreButton").hide();
		}
	});

	$("#btnSearch").click(function() {
		search_addr = $("#search_addr").val().trim();
		search_date = $("#date_range_picker_input").val().trim();
		search_person = $("#search_person").val().trim();


		var url = "/accomodation/accomodationMain?addr=" + search_addr + "&date=" + search_date + "&person=" + search_person;
		location.href = url;
	});



	$(".pad").on("click", function() {
		filterButtonIndex = $(this).index() - 1;
	});

	var translationMap = {
		"스파": "spa",
		"키친": "kitchen",
		"바베큐": "bbq",
		"수영장": "pool",
		"와이파이": "wifi",
		"주차": "parking",
		"반려견 동반": "pet",
		"노래방": "karaoke"
	};

	$(".accmodation_checkbox_filter_label input[type='checkbox']").change(function() {
		var divValue = $(this).siblings("div").text();
		var translatedValue = translationMap[divValue];

		if ($(this).is(":checked")) {
			filterCheckbox.push(translatedValue);
		} else {
			filterCheckbox = filterCheckbox.filter((value) => value !== translatedValue);
		}
	});


	$(".btn-danger").click(function() {
		var filter_data = [];
		if (filterButtonIndex >= 0) {
			filter_data.push(filterButtonIndex);
			console.log(filterButtonIndex);
		}

		for (var i = 0; i < filterCheckbox.length; i++) {
			filter_data.push(filterCheckbox[i]);
		}

		if (filter_data.length > 0) {
			var url = "/filterList?filterData=" + filter_data;
			location.href = url;
			/*$.ajax({
				url: "/filterList",
				traditional: true,
				data: { filterData: filter_data },
				success: function() {
				},
				error: function(error) {
					console.error("Error:", error);
				}
			});*/
		}

	});


	$('.pad').on('click', function() {
		$('.pad').removeClass('click_event');
		$(this).addClass('click_event');
	});

	$("#date_range_picker").daterangepicker(
		{
			autoUpdateInput: false,
			showDropdowns: false, // 월과 연도 드롭다운 설정
			startDate: today,
			endDate: today,
			autoclose: true,
			minDate: moment(),
			opens: 'bottom',
			locale: {
				format: 'YYYY/MM/DD',
				separator: ' ~ ', // 선택한 날짜 사이 구분자 설정
				applyLabel: '적용', // 적용 버튼 텍스트 설정
				cancelLabel: '취소', // 취소 버튼 텍스트 설정
				daysOfWeek: ['일', '월', '화', '수', '목', '금', '토'], // 요일 이름 설정
				monthNames: ['1월', '2월', '3월', '4월', '5월', '6월',
					'7월', '8월', '9월', '10월', '11월', '12월'], // 월 이름 설정
				firstDay: 0, // 첫 번째 날을 일요일로 설정
				language: "ko" // 달력의 언어 선택
			},

		});
	$("#date_range_picker").on("apply.daterangepicker",
		function(ev, picker) {
			$("#date_range_picker_input").val(
				picker.startDate.format("YYYY/MM/DD") + ' ~ '
				+ picker.endDate.format("YYYY/MM/DD"));
		});


	$("#date_range_picker").on("cancel.daterangepicker",
		function(ev, picker) {
			$("#date_range_picker_input").val("");
		});

	$("#date_range_picker_input").val(today + ' ~ ' + today); // 초기 값을 오늘로 설정
	// 달력 자바 스크립트
});
