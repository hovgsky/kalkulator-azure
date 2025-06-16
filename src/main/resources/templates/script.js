async function calculate() {
  const expr = document.getElementById("expression").value;
  const response = await fetch("/api/calculate", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ expression: expr })
  });

  const result = await response.text();
  document.getElementById("result").innerText = `Wynik: ${result}`;

  const li = document.createElement("li");
  li.textContent = `${expr} = ${result}`;
  document.getElementById("historyList").appendChild(li);
}
