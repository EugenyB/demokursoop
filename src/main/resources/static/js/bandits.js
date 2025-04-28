let myAddBanditDialog = document.getElementById("add_bandit");
myAddBanditDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    let form = document.getElementById("add_bandit_form");
    form.setAttribute('action', link);
    let name = button.getAttribute('data-bs-name');
    let nickname = button.getAttribute('data-bs-nickname');
    let birthday = button.getAttribute('data-bs-birthday');
    let gang = button.getAttribute('data-bs-gang');
    let crimeType = button.getAttribute('data-bs-crimetype');
    let crimeCount = button.getAttribute('data-bs-crimecount');

    let idField = document.getElementById("b_id");
    let nameEdit = document.getElementById("b_name");
    let nickNameEdit = document.getElementById("b_nickname");
    let birthdayEdit = document.getElementById("b_birthday");
    let gangEdit = document.getElementById("b_gang");
    let crimeTypeEdit = document.getElementById("b_crimetype");
    let crimeCountEdit = document.getElementById("b_crimecount");
    let approveButton = document.getElementById("approve_button");

    let dialogTitle = myAddBanditDialog.querySelector('.modal-title');
    if (button.getAttribute('data-bs-ident') === '#add') {
        idField.value = '0';
        nameEdit.value = '';
        nickNameEdit.value = '';
        birthdayEdit.value = '';
        gangEdit.value = '';
        crimeTypeEdit.value = '';
        crimeCountEdit.value = '';

        approveButton.textContent = "Add";
        dialogTitle.textContent = "Add Bandit";
    } else {
        idField.value = button.getAttribute('data-bs-id');
        nameEdit.value = name;
        nickNameEdit.value = nickname;
        birthdayEdit.value = birthday;
        gangEdit.value = gang;
        crimeTypeEdit.value = crimeType;
        crimeCountEdit.value = crimeCount;

        dialogTitle.textContent = "Edit Bandit";
        approveButton.textContent = "Update";
    }
});