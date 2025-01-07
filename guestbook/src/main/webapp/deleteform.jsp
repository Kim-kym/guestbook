<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>방명록</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <form method="post" action="delete.php">
        <input type='hidden' name="id" value="">
        <div class="mb-3">
            <label for="password" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-primary">확인</button>
            <a href="index.php" class="btn btn-secondary">메인으로 돌아가기</a>
        </div>
    </form>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>