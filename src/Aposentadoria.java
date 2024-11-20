import java.util.Scanner;

public class Aposentadoria {
    private int idade;
    private String sexo;
    private int anosContribuicao;

    public Aposentadoria(int idade, String sexo, int anosContribuicao) {
        this.idade = idade;
        this.sexo = sexo;
        this.anosContribuicao = anosContribuicao;
    }

    public String verificarAposentadoria() {
        int idadeMinima = sexo.equalsIgnoreCase("feminino") ? 62 : 65;
        int anosContribuicaoMinimo = sexo.equalsIgnoreCase("feminino") ? 30 : 35;

        if (idade >= idadeMinima && anosContribuicao >= 15 && anosContribuicao < anosContribuicaoMinimo ){
            return "Você já pode se Aposentar por Idade e Tempo Mínimo.";
        }
        if (idade >= idadeMinima && anosContribuicao >= anosContribuicaoMinimo) {
            return "Você já pode se Aposentar na Totalidade.";
        } else {
            int anosParaIdade = Math.max(idadeMinima - idade, 0);
            int anosParaContribuicao = Math.max(anosContribuicaoMinimo - anosContribuicao, 0);
            int anosContribuicaoMinima = 15 - anosContribuicao;
            if (idade >= idadeMinima){
                return "Atingiu a Idade Minima para Aposentadoria, faltando apenas " + anosContribuicaoMinima +" de contribuição minima";
            }
            return "Faltam " + anosParaIdade + " anos para atingir a idade mínima e " +
                    anosParaContribuicao + " anos de contribuição para Totalidade.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite Sexo: (masculino ou feminino): ");
        String sexo = scanner.nextLine();

        System.out.print("Digite seus Anos de contribuição: ");
        int anosContribuicao = scanner.nextInt();

        Aposentadoria pessoa = new Aposentadoria(idade, sexo, anosContribuicao);
        System.out.println(pessoa.verificarAposentadoria());
    }
}