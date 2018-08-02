package com.neuedu.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SignUtil {

	public static List<List<DateInfo>> getCalendarTable(List<String> dateList, String todayStr) throws Exception {
		List<Integer> signedList = dateList.stream()
				.map(date -> Integer.parseInt(date.substring(8)))
				.collect(Collectors.toList());
		LocalDate today = LocalDate.parse(todayStr);

		Predicate<Integer> isSigned = date -> signedList.contains(date);
		Predicate<Integer> isToday = date -> date.equals(today.getDayOfMonth());

		// 只有完成签到的具体日期会存入数据库，关于"今天是几号"、"哪些天数不可用"
		// 不应该过问数据库，应该由后台自行判断后交付前台最终核对结果
		// 也就是说，一个int的list存入redis即可，不需要多余的内容
		// 相对的，service层以上应该把上述数据完全处理好后再发给前端
		// state: disabled, enabled, signed, today, signed-today
		System.out.println(today);

		int frontCount = today.minusMonths(1).lengthOfMonth();
		List<DateInfo> head = IntStream
				.rangeClosed(frontCount - today.withDayOfMonth(1).getDayOfWeek().getValue() + 1, frontCount).boxed()
				.map(date -> DateInfo.of(date, "disabled")).collect(Collectors.toList());
		List<DateInfo> base = IntStream.rangeClosed(1, today.lengthOfMonth()).boxed()
				.map(date -> DateInfo.of(date, "enabled")).map(dateinfo -> {
					if (isToday.test(dateinfo.getDate())) {
						dateinfo.setState("today");
					}
					return dateinfo;
				}).map(dateinfo -> {
					if (isSigned.test(dateinfo.getDate())) {
						if (isToday.test(dateinfo.getDate())) {
							dateinfo.setState("signed-today");
						} else {
							dateinfo.setState("signed");
						}
					}
					return dateinfo;
				}).collect(Collectors.toList());
		List<DateInfo> tail = IntStream.rangeClosed(1, 42 - head.size() - base.size()).boxed()
				.map(date -> DateInfo.of(date, "disabled")).collect(Collectors.toList());

		head.addAll(base);
		head.addAll(tail);

		List<List<DateInfo>> result = new ArrayList<>();
		
		for (int i = 0; i < 6; i++) {
			result.add(head.subList(i * 7, (i + 1) * 7));
		}
		result.forEach(ele -> {
			for (DateInfo subele : ele) {
				try {
					System.out.print(JsonUtils.ObjectToJson(subele) + " ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						throw e;
					} catch (Exception ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
				}
			}
			System.out.println();
		});
		
		return result;
	}
}
