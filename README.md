# 課題 12-3: 文字列の類似性

### 課題の説明
課題12-1で作成したDNAクラスに、２つの異なるDNA文字列の類似性を計算するメソッドを作成する。
ここでは文字列の類似度としてよく利用されるレーベンシュタイン距離を求める。
レーベンシュタイン距離をもとめるためのアルゴリズムは以下を疑似コードを参考にすること


| メソッド名                  | 引数のリスト     | 戻り値の型 | アクセス修飾子 |
|------------------------|------------|-------|--------|
| getLevenshteinDistance | String str | int   | public | 

### レーベンシュタイン距離を求める疑似コード

```
1. str1の文字数をM、str2の文字数をNとする
2. [[ 1, 2, 3, 4, ... ]
    [ 2, 0, 0, 0, ... ]
    [ 3, 0, 0, 0, ... ]
    [ ...             ]] のように初期化する
3. for(i=1; i<M; i++)
      for(j=1; j<N; j++)
          str1[i]とstr2[j]が等しければ cost = 0 そうでなければ cost = 1 とする
          d[i][j] = 最小値(d[i-1][j] + 1, d[i][j-1] + 1, cost) 
4. d[M -1][N -1] がレーベンシュタイン距離となる
```

### ProgC3.java (提出不要)
```java
public class ProgC3 {

    public static void main(String[] args) {
        DNA dna = new DNA();
        dna.str = "AGCTCGAATATGC";
        System.out.println(dna.getLevenshteinDistance("ACTGAAGAGC"));
    }
}
```


### 実行例
```
4
```
