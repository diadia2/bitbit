<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=046ac75236bb37b591a0184249baa017"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var container = document.getElementById('map'); //������ ���� ������ DOM ���۷���
		var options = { //������ ������ �� �ʿ��� �⺻ �ɼ�
			center: new daum.maps.LatLng(33.450701, 126.570667), //������ �߽���ǥ.
			level: 3 //������ ����(Ȯ��, ��� ����)
		};
		
		$('#btn01').click(function(){
			setBounds();
		});

		var map = new daum.maps.Map(container, options); //���� ���� �� ��ü ����
		
		// ��ư�� Ŭ���ϸ� �Ʒ� �迭�� ��ǥ���� ��� ���̰� ���� ������ �缳���մϴ� 
		var points = [
		    new daum.maps.LatLng(37.404787, 126.907456),
		    new daum.maps.LatLng(37.404787, 126.907456),
		    new daum.maps.LatLng(37.404787, 126.907456)
		];

		// ������ �缳���� ���������� ������ ���� LatLngBounds ��ü�� �����մϴ�
		var bounds = new daum.maps.LatLngBounds();    

		var i, marker;
		for (i = 0; i < points.length; i++) {
		    // �迭�� ��ǥ���� �� ���̰� ��Ŀ�� ������ �߰��մϴ�
		    marker = new daum.maps.Marker({ position : points[i] });
		    marker.setMap(map);
		    
		    // LatLngBounds ��ü�� ��ǥ�� �߰��մϴ�
		    bounds.extend(points[i]);
		}

		function setBounds() {
		    // LatLngBounds ��ü�� �߰��� ��ǥ���� �������� ������ ������ �缳���մϴ�
		    // �̶� ������ �߽���ǥ�� ������ ����� �� �ֽ��ϴ�
		    map.setBounds(bounds);
		}
		////////////////////////////////////////////////////////////////////
		
		// ��Ŀ�� ǥ�õ� ��ġ�Դϴ� 
		var markerPosition  = new daum.maps.LatLng(33.450701, 126.570667); 

		// ��Ŀ�� �����մϴ�
		var marker = new daum.maps.Marker({
	    position: markerPosition
		});

		// ��Ŀ�� ���� ���� ǥ�õǵ��� �����մϴ�
		marker.setMap(map);
	});

</script>
</head>
<body>
	<h2>���� ����</h2>
	<div id="map" style="width:1000px;height:450px; border:1px solid red"></div>
	<button id = "btn01">�츮�� ���� ����</button> 
	
</body>
</html>