<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Tasks - Task Management</title>
    <link
      rel="stylesheet"
      href="/webjars/bootstrap/5.3.8/css/bootstrap.min.css"
    />
  </head>
  <body>
    <%@ include file="../common/navigation.jspf" %>
    <main class="container mt-4">
      <h1 class="d-flex justify-content-between align-items-center">
        Tasks
        <a href="/tasks/create" class="btn btn-success">Add task</a>
      </h1>
      <p>You have following tasks.</p>
      <ul class="list-unstyled">
        <c:forEach var="task" items="${tasks}">
          <li class="mb-2">
            <section class="card">
              <div class="card-body">
                <h5
                  class="card-title d-flex justify-content-between align-items-center"
                >
                  <span>
                    ${task.title}
                    <c:if test="${task.done}">
                      <span class="badge text-bg-success">Completed</span>
                    </c:if>
                  </span>
                  <div class="d-flex align-items-center">
                    <div class="actions">
                      <a
                        href="/tasks/edit/${task.id}"
                        class="btn btn-sm btn-primary"
                        >Edit</a
                      >
                      <button
                        class="btn btn-sm btn-danger"
                        data-bs-toggle="modal"
                        data-bs-target="#deleteTaskConfirmModal"
                        data-bs-task-title="${task.title}"
                        data-bs-task-id="${task.id}"
                      >
                        Delete
                      </button>
                    </div>
                    <span
                      class="badge bg-secondary lh-base fw-semibold text-uppercase"
                    ></span>
                  </div>
                </h5>
                <h6 class="card-subtitle mb-2 text-muted">
                  Due date: ${task.targetDate}
                </h6>
                <p class="card-text">${task.description}</p>
              </div>
            </section>
          </li>
        </c:forEach>
      </ul>
      <!-- Modal -->
      <div
        class="modal fade"
        id="deleteTaskConfirmModal"
        data-bs-backdrop="static"
        data-bs-keyboard="false"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">Confirm</h1>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div class="modal-body">
              <p class="modal-content">Are you sure want to delete the task?</p>
            </div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-secondary"
                data-bs-dismiss="modal"
                id="deleteTaskConfirmModalCancelButton"
              >
                Close
              </button>
              <button
                type="button"
                class="btn btn-primary"
                id="deleteTaskModalConfirmButton"
              >
                Confirm
              </button>
            </div>
          </div>
        </div>
      </div>
    </main>
    <script src="/webjars/bootstrap/5.3.8/js/bootstrap.min.js"></script>
    <script>
      document.addEventListener("DOMContentLoaded", function () {
        const deleteTaskConfirmModal = document.getElementById(
          "deleteTaskConfirmModal"
        );
        const cancelDeleteButton = document.getElementById(
          "deleteTaskConfirmModalCancelButton"
        ); // Your modal's cancel button
        let confirmDeleteButton;
        let handleCancelClick;

        if (deleteTaskConfirmModal) {
          deleteTaskConfirmModal.addEventListener("show.bs.modal", (event) => {
            // Button that triggered the modal
            const button = event.relatedTarget;

            // Extract info from data-bs-* attributes
            const taskTitle = button.getAttribute("data-bs-task-title");
            const taskId = button.getAttribute("data-bs-task-id");

            const redirectUrl = "/tasks/delete/" + taskId;

            console.debug("task id to delete: ", taskId);
            console.debug("delete task url: ", redirectUrl);

            // Update the modal's content.
            const modalBody =
              deleteTaskConfirmModal.querySelector(".modal-body");

            modalBody.innerHTML =
              "<p>Are you sure want to delete the task <em>" +
              taskTitle +
              "</em>?<p>";

            // Define the click handler for the confirm button
            function handleConfirmClick() {
              console.debug("Confirm clicked. Redirecting to:", redirectUrl);
              window.location.href = redirectUrl; // Redirect to the specified URL
            }

            // Attach the event listener to the confirm button
            confirmDeleteButton = document.getElementById(
              "deleteTaskModalConfirmButton"
            ); // Your modal's confirm button
            confirmDeleteButton.addEventListener("click", handleConfirmClick);

            // Define the click handler for the cancel button
            handleCancelClick = function () {
              if (!confirmDeleteButton) return;
              // Remove the event listener from the confirm button when cancel is clicked
              confirmDeleteButton.removeEventListener(
                "click",
                handleConfirmClick
              );
              console.debug("Event listener for confirm button removed.");
            };

            // Attach the event listener to the cancel button
            cancelDeleteButton.addEventListener("click", handleCancelClick);
          });

          // Optional: Remove event listeners when the modal is hidden
          deleteTaskConfirmModal.addEventListener(
            "hidden.bs.modal",
            function () {
              console.debug("Task delete confirm modal hidden.");

              // Ensure event listeners are removed if the modal is closed by other means (e.g., escape key, backdrop click)
              // This is a safety measure to prevent multiple listeners if the modal is opened and closed repeatedly without clicking cancel.
              const clonedConfirmButton = confirmDeleteButton.cloneNode(true);
              confirmDeleteButton.parentNode.replaceChild(
                clonedConfirmButton,
                confirmDeleteButton
              );
              // Re-get the new confirm button element if needed for future interactions
              confirmDeleteButton = document.getElementById(
                "deleteTaskModalConfirmButton"
              );
              console.debug("Task delete confirm modal close button cloned.");

              cancelDeleteButton.removeEventListener(
                "click",
                handleCancelClick
              );
              console.debug("Eent listener for close button removed.");
            }
          );
        }
      });
    </script>
  </body>
</html>
