object dm: Tdm
  OldCreateOrder = False
  OnCreate = DataModuleCreate
  Left = 229
  Top = 131
  Height = 480
  Width = 696
  object ADOConnection1: TADOConnection
    LoginPrompt = False
    Mode = cmReadWrite
    Provider = 'MSDASQL.1'
    Left = 80
    Top = 40
  end
end
