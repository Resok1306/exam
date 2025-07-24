    function validatePassword() {
        const password = document.getElementById("password").value;
        const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^a-zA-Z\d]).{8,}$/;
		const pwConfirm = document.getElementById('passwordConfirm').value;

        if (password !== pwConfirm) {
            alert('비밀번호가 일치하지 않습니다. 다시 확인해주세요.');
            return false; // 제출 차단
        }
        if (!regex.test(password)) {
           	 alert("비밀번호는 8자 이상이며, 영문 대소문자, 숫자, 특수문자를 모두 포함해야 합니다.");
            return false;
        }
        return true;
    }
    // 비밀번호와 비밀번호 확인 일치 여부 검사 후 메시지 표시
    function checkPasswordMatch() {
        const pw = document.getElementById('password').value;
        const pwConfirm = document.getElementById('passwordConfirm').value;
        const msgEl = document.getElementById('passwordMatchMessage');

        if (pw === pwConfirm) {
            msgEl.style.color = 'green';
            msgEl.textContent = '비밀번호가 일치합니다.';
        } else {
            msgEl.style.color = 'red';
            msgEl.textContent = '비밀번호가 일치하지 않습니다.';
        }
    }