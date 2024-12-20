# 事前準備
## 共通
- OS に合わせた docker desktop をインストール
  - [Windows](https://docs.docker.com/desktop/install/windows-install/)
  - [Mac](https://docs.docker.com/desktop/install/mac-install/)
## windows の場合
1. Microsoft Store から Ubuntu をインストール
2. 「スタートボタン」→「Windowsシステムツール」→「コントロールパネル」→「プログラム」→「Windowsの機能の有効化または無効化」を開き、「Linux用Windowsサブシステム（WSL）」と「仮想マシン プラットフォーム」にチェックを入れ「OK」
3. 再起動
4. Ubuntu を起動し、ユーザー名とパスワードを入力

# セットアップ

## docker イメージ作成
```
docker-compose build
docker-compose up -d
```

## サーバー起動
```
docker-compose up -d
open http://localhost:3000/
```
