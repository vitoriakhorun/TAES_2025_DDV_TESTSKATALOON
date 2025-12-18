Foi feita uma alteraçao dia 18/12/2025 para prepar os testes para a apresentação.

Para testar os testes kataloon do ChangeProfielPhoto , no filePath é precsio colocar lá o path das photos do projeto , pois muda a cada base de dados.Por exemplo :C:\\Users\\khoru\\Documents\\GitHub\\TAES2025_G3_DDV\\api\\public\\storage\\photos_avatars\\00002_VlSjFhJNbR.jpeg

O teste de comprarPersonalizacaoCartas apenas funciona se o utilizador tiver coins suficientes , para isso ou comprar mais cartas ou mudar na base de dados.
O teste de PersonaliarCartas funciona apenas se a compra já tiver feita , se nao tiver ele falha.Tambem nao funciona se a personalizaçao já tiver feita , para isso é necessário mudar na base de dados e meter  acoluna costum a 0.
