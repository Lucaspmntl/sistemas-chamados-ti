document.addEventListener("DOMContentLoaded", function () {
    const themeToggle = document.getElementById("theme-toggle");
    const currentTheme = localStorage.getItem("theme");

    if (currentTheme === "dark") {
        document.documentElement.setAttribute("data-theme", "dark");
        themeToggle.textContent = "☀️";
    } else {
        themeToggle.textContent = "🌙";
    }

    if (themeToggle) {
        themeToggle.addEventListener("click", function () {
            const current = document.documentElement.getAttribute("data-theme");
            if (current === "dark") {
                document.documentElement.setAttribute("data-theme", "light");
                localStorage.setItem("theme", "light");
                themeToggle.textContent = "🌙";
            } else {
                document.documentElement.setAttribute("data-theme", "dark");
                localStorage.setItem("theme", "dark");
                themeToggle.textContent = "☀️";
            }
        });
    }

    document.querySelectorAll("a[data-confirm]").forEach(function (el) {
        el.addEventListener("click", function (e) {
            if (!confirm(el.getAttribute("data-confirm"))) {
                e.preventDefault();
            }
        });
    });

function validarSenha() {
    const senhaInput = document.getElementById("senha");
    const mensagem = document.getElementById("mensagem-senha");

    const regex = /^(?=.*[A-Z])(?=.*\d).{6,}$/;

    if (!regex.test(senhaInput.value)) {
        mensagem.style.display = "block";
        return false;
    }

    mensagem.style.display = "none";
    return true;
}

    <script th:inline="javascript">
        setTimeout(() => {
            const row = document.querySelector('.chamado-destacado');
            if (row) {
                row.classList.add('chamado-destacado-temporario');
                setTimeout(() => {
                    row.classList.remove('chamado-destacado');
                    row.classList.add('chamado-destacado-sumir');
                }, 1000);
            }
        }, 3000);
    </script>

});