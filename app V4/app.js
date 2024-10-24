function verificarNota() {
  // Obter os elementos de nome e nota do aluno
  let nome = document.querySelector('#nome');
  let nota = document.querySelector('#nota');
  
  // Elemento para exibir mensagens de erro ou resultados
  let msgError = document.querySelector('#msgError');
  let resultado = document.querySelector('#resultado');
  
  // Resetar as mensagens e estilo de erro
  msgError.setAttribute('style', 'display: none');
  resultado.innerHTML = '';
  nome.setAttribute('style', 'border-color: #042b0b');
  nota.setAttribute('style', 'border-color: #042b0b');
  
  // Verificar se o campo de nome e nota estão preenchidos
  if (nome.value === '' || nota.value === '') {
    msgError.setAttribute('style', 'display: block');
    msgError.innerHTML = 'Por favor, preencha todos os campos';
    
    // Destacar o campo vazio
    if (nome.value === '') {
      nome.setAttribute('style', 'border-color: red');
    }
    
    if (nota.value === '') {
      nota.setAttribute('style', 'border-color: red');
    }
    
    return; // Não continuar se os campos estiverem vazios
  }

  // Converter a nota para um número
  let notaAluno = Number(nota.value);

  // Verificar se a nota é válida (entre 0 e 100)
  if (isNaN(notaAluno) || notaAluno < 0 || notaAluno > 100) {
    msgError.setAttribute('style', 'display: block');
    msgError.innerHTML = 'Insira uma nota válida entre 0 e 100';
    nota.setAttribute('style', 'border-color: red');
    return;
  }

  // Lógica de aprovação ou reprovação
  if (notaAluno >= 60) {
    resultado.innerHTML = `<p style="color: green; font-weight: bold;">Aluno ${nome.value} está APROVADO com nota ${notaAluno}</p>`;
  } else {
    resultado.innerHTML = `<p style="color: red; font-weight: bold;">Aluno ${nome.value} está REPROVADO com nota ${notaAluno}</p>`;
  }
}

  // Função para resetar os campos
  function resetarCampos() {
    nome.value = '';
    nota.value = '';
    resultado.innerHTML = '';
    msgError.style.display = 'none';
    nome.style.borderColor = '#042b0b';
    nota.style.borderColor = '#042b0b';
  }

  // Adicionar evento de clique ao link "Clique aqui"
  resetLink.addEventListener('click', (e) => {
    e.preventDefault(); // Prevenir comportamento padrão do link
    resetarCampos();
  });

