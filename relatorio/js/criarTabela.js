
function criarTabela(){
	// Captura a referência da tabela com id “minhaTabela”
	var table = document.getElementById("minhaTabela");

	for(var i = 0; i < 3; i++)
	{
		var newRow = table.insertRow(i);
		for(var j = 0; j < 34; j++) 
		{
			newCell = newRow.insertCell(j);
			newCell.innerHTML = "Linha "+ numOfRows + " – Coluna "+ j;
		}
		
	}
}