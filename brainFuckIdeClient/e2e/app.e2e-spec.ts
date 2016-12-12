import { BrainFuckIDEClientPage } from './app.po';

describe('brain-fuck-ideclient App', function() {
  let page: BrainFuckIDEClientPage;

  beforeEach(() => {
    page = new BrainFuckIDEClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
